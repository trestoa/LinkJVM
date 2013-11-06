/*
* This file is part of LinkJVM.
*
* Java Framework for the KIPR Link
* Copyright (C) 2013 Markus Klein <m@mklein.co.at>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

%module linkjvm_camera
%{
    #include "include/kovan/geom.hpp"
    #include "include/kovan/color.hpp"
    #include "include/kovan/config.hpp"
    #include <cstring>
    #include <string>
    #include <vector>
    #include <map>
    #include <iostream>
    #include <time.h>
    #include <winsock2.h>
%}

%include "stl.i"

class Config
{
    public:
        Config();
        Config(const std::map<std::string, std::string> &config);

        static Config *load(const std::string &path);
        bool save(const std::string &path) const;

        void beginGroup(const std::string &group);
        void endGroup();
        void clearGroup();

        void clear();

        bool containsKey(const std::string &key) const;

        bool boolValue(const std::string &key) const;
        int intValue(const std::string &key) const;
        double doubleValue(const std::string &key) const;
        std::string stringValue(const std::string &key) const;

        void setValue(const std::string &key, const bool &value);
        void setValue(const std::string &key, const int &value);
        void setValue(const std::string &key, const double &value);
        void setValue(const std::string &key, const char *value);
        void setValue(const std::string &key, const std::string &value);

        Config values() const;
        void addValues(const Config &config);

    private:
        std::string safeKey(std::string key) const;
        std::string group() const;

        std::map<std::string, std::string> m_config;
        std::vector<std::string> m_groups;
        mutable std::string m_cachedGroup;
};

#define CAMERA_GROUP ("camera")
#define CAMERA_NUM_CHANNELS_KEY ("num_channels")
#define CAMERA_CHANNEL_GROUP_PREFIX ("channel_")
#define CAMERA_CHANNEL_TYPE_KEY ("type")

#define CAMERA_CHANNEL_TYPE_HSV_KEY ("hsv")
#define CAMERA_CHANNEL_TYPE_QR_KEY ("qr")

namespace cv{
    class VideoCapture;
}

namespace Camera{
        class Device;

    class Object{
                public:
                 Object(const Point2<unsigned> &centroid,
                 const Rect<unsigned> &boundingBox,
                 const double &confidence, const char *data = 0,
                 const size_t &dataLength = 0);
                 Object(const Object &rhs);
                 ~Object();

                 const Point2<unsigned> &centroid() const;
                 const Rect<unsigned> &boundingBox() const;
                 const double confidence() const;
                 const char *data() const;
                 const size_t dataLength() const;

            private:
            Point2<unsigned> m_centroid;
            Rect<unsigned> m_boundingBox;
            double m_confidence;
            char *m_data;
            size_t m_dataLength;
    };

       typedef std::vector<Object> ObjectVector;

    class ChannelImpl{
            public:
            ChannelImpl();
            virtual ~ChannelImpl();

            void setImage(const cv::Mat &image);
            ObjectVector objects(const Config &config);

            protected:
            virtual void update(const cv::Mat &image) = 0;
            virtual ObjectVector findObjects(const Config &config) = 0;

            private:
            bool m_dirty;
            cv::Mat m_image;
    };

    class ChannelImplManager{
            public:
            virtual ~ChannelImplManager();
            virtual void setImage(const cv::Mat &image) = 0;
            virtual ChannelImpl *channelImpl(const std::string &name) = 0;
    };

    class DefaultChannelImplManager : public ChannelImplManager{
            public:
            DefaultChannelImplManager();
            ~DefaultChannelImplManager();

            virtual void setImage(const cv::Mat &image);
            virtual ChannelImpl *channelImpl(const std::string &name);

            private:
            std::map<std::string, ChannelImpl *> m_channelImpls;
    };
    class Channel{
            public:
            Channel(Device *device, const Config &config);
            ~Channel();

            void invalidate();

            const ObjectVector *objects() const;

            Device *device() const;

            /**
             * Do not call this method unless you know what you are doing!
             */
            void setConfig(const Config &config);

            private:
            Device *m_device;
            Config m_config;
            mutable ObjectVector m_objects;
            ChannelImpl *m_impl;
            mutable bool m_valid;
    };
    typedef std::vector<Channel *> ChannelPtrVector;
    class ConfigPath{
                   public:
            static std::string extension();

            static void setBasePath(const std::string &path);
            static std::string path(const std::string &name = std::string());
            static std::string defaultPath();
            static std::string defaultConfigPath();
            static void setDefaultConfigPath(const std::string &name);

            private:
            static std::string s_path;
    };

    class InputProvider{
            public:
            virtual ~InputProvider();
            virtual bool open(const int number) = 0;
            virtual bool isOpen() const = 0;
            virtual void setWidth(const unsigned width) = 0;
            virtual void setHeight(const unsigned height) = 0;
            virtual bool next(cv::Mat &image) = 0;
            virtual bool close() = 0;
    };

    class UsbInputProvider : public InputProvider{
            public:
            UsbInputProvider();
            ~UsbInputProvider();

            virtual bool open(const int number);
            virtual bool isOpen() const;
            virtual void setWidth(const unsigned width);
            virtual void setHeight(const unsigned height);
            virtual bool next(cv::Mat &image);
            virtual bool close();

            private:
            cv::VideoCapture *m_capture;
    };

    class Device{
            public:
            Device(InputProvider *const inputProvider);
            ~Device();

            bool open(const int number = 0);
            bool isOpen() const;
            bool close();
            bool update();

            void setWidth(const unsigned width);
            void setHeight(const unsigned height);

            unsigned width() const;
            unsigned height() const;

            const ChannelPtrVector &channels() const;

            InputProvider *inputProvider() const;
            const cv::Mat &rawImage() const;

            void setConfig(const Config &config);
            const Config &config() const;

            void setChannelImplManager(ChannelImplManager *channelImplManager);
            ChannelImplManager *channelImplManager() const;

            const unsigned char *bgr() const;

         private:
         void updateConfig();

         InputProvider *const m_inputProvider;
         Config m_config;
         ChannelPtrVector m_channels;
         ChannelImplManager *m_channelImplManager;
         cv::Mat m_image;
         timeval m_lastUpdate;

         mutable unsigned char *m_bgr;
         mutable unsigned m_bgrSize;
    };

    Camera::Device *cDevice();
    %template(ChannelVector) std::vector<Channel *>;
    %template(ObjectVector) std::vector<Object>;
}