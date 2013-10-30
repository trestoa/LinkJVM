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

%module LinkJVM
%{
	#include "include/kovan/export.hpp"
	#include "include/kovan/port.hpp"
	#include "include/kovan/kovan.hpp"
	#include "include/kovan/geom.hpp"
	#include "include/kovan/color.hpp"
	#include "include/kovan/config.hpp"
	#include <cstring>
	#include <string>
	#include <vector>
	#include <map>
	#include <iostream>
	#include <opencv2/core/core.hpp>
	#include <cstdio>
	#include <cstdlib>
	#include <time.h>
	#include <winsock2.h>
%}

/* Sensor */
template<typename T> class  Sensor{
	public:
		virtual ~Sensor() {}
		virtual T value() const = 0;
};

%template(IntSensor) Sensor<int>;
%template(UnsingnedShortSensor) Sensor<unsigned short>;
%template(ShortSensor) Sensor<short>;
%template(BoolSensor) Sensor<bool>;
%template(UnsignedCharSensor) Sensor<unsigned char>;
%template(CharSensor) Sensor<char>;

/* Motor */
class  Motor{
	public:
		Motor(const port_t& port) throw(); 
		void clearPositionCounter();	
		void moveAtVelocity(const short& velocity);
		void moveToPosition(const short& speed, const int& goalPos);
		void moveRelativePosition(const short& speed, const int& deltaPos);
		void setPidGains(const short& p, const short& i, const short& d, const short& pd, const short& id, const short& dd);
		void pidGains(short& p, short& i, short& d, short& pd, short& id, short& dd);
		void freeze();
		bool isMotorDone() const;
		void blockMotorDone() const;
		void forward();
		void backward();
		void motor(int percent);
		void off();
		const port_t& port() const;
	        
	private:
	        port_t m_port;
};

class BackEMF : public Sensor<int>{
	public:
		BackEMF(const unsigned char& port);
		virtual int value() const;
		unsigned char port() const;
	        
	private:
		unsigned char m_port;
};

/* Servo */
class  Servo{
	public:
		typedef unsigned int ticks_t;
		Servo(port_t port);
		void setPosition(ticks_t position);
		ticks_t position() const;
		void disable();
		void enable();
		void setEnabled(const bool &enabled);
		bool isEnabled() const;
		
	private:
	    port_t m_port;
};

/* Analog */
class  Analog : public Sensor<unsigned short>{
	public:
		Analog(const unsigned char& port);
		virtual unsigned short value() const;
		virtual void setPullup(bool pullup);
		virtual bool pullup() const;
		unsigned char port() const;
	        
	private:
		unsigned char m_port;
};

class  Analog8 : public Analog{
	public:
		Analog8(const unsigned char& port);
		virtual unsigned short value() const;
};

/* Digital */
class  Digital : public Sensor<bool>{
	public:
		Digital(const unsigned char& port);
		virtual void setValue(const bool& value);
		virtual bool value() const;
		virtual void setOutput(const bool& output);
		virtual bool isOutput() const;
		virtual void setPullup(const bool& pullup);
		virtual bool pullup() const;
	private:
		unsigned char m_port;
};

/* button ids */
namespace Button{
	namespace Type{
	    enum Id {
            A,
            B,
            C,
            X,
            Y,
            Z,
            Side
	    };
	}
}

/* button */
class  AbstractButton : public Sensor<bool>{
	public:
	    virtual ~AbstractButton();
	    virtual void setPressed(bool pressed) = 0;
	    inline bool isPressed() const { return value(); };
	    inline bool isNotPressed() const { return !isPressed(); }
	    inline bool isClicked() const
	    {
	            const bool ret = isPressed();
	            waitUntilReleased();
	            return ret;
	    }
	    virtual void waitUntilReleased() const;
	    virtual void waitUntilPressed() const;
	    virtual void waitUntilClicked() const;
};

class  AbstractTextButton : public AbstractButton{
	public:
        virtual ~AbstractTextButton();
        virtual void setText(const char *text) = 0;
        virtual const char *text() const = 0;
        virtual bool isTextDirty() const = 0;
    	virtual void resetText() = 0;
};

class  IdButton : public AbstractTextButton{
	public:
	    IdButton(const Button::Type::Id& id, const char *defaultText);
	    ~IdButton();
	    
	    virtual void setText(const char *text);
	    virtual const char *text() const;
	    virtual bool isTextDirty() const;
	    virtual void setPressed(bool pressed);
	    virtual bool value() const;
	    virtual void resetText();
        
	private:
	    Button::Type::Id m_id;
	    char *m_defaultText;
};

class  ExtraButtons{
	public:
	    static void show();
	    static void hide();
	    static void setShown(const bool& shown);
	    static bool isShown();
};

namespace Button{
	extern  IdButton A;
	extern  IdButton B;
	extern  IdButton C;
	
	extern  IdButton X;
	extern  IdButton Y;
	extern  IdButton Z;
	
	extern  IdButton Side;
	
	extern  IdButton *const all[7];
}

/* Camera */
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
        
    class  Object{
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
        
    class  ChannelImpl{
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
    
    class  ChannelImplManager{
    	public:
            virtual ~ChannelImplManager();
            virtual void setImage(const cv::Mat &image) = 0;
            virtual ChannelImpl *channelImpl(const std::string &name) = 0;
    };
    
    class  DefaultChannelImplManager : public ChannelImplManager{
    	public:
            DefaultChannelImplManager();
            ~DefaultChannelImplManager();
            
            virtual void setImage(const cv::Mat &image);
            virtual ChannelImpl *channelImpl(const std::string &name);
            
    	private:
            std::map<std::string, ChannelImpl *> m_channelImpls;
    };
    
    class  Channel{
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
    
    class  ConfigPath{
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
    
    class  InputProvider{
    	public:
            virtual ~InputProvider();
            virtual bool open(const int number) = 0;
            virtual bool isOpen() const = 0;
            virtual void setWidth(const unsigned width) = 0;
            virtual void setHeight(const unsigned height) = 0;
            virtual bool next(cv::Mat &image) = 0;
            virtual bool close() = 0;
    };
    
    class  UsbInputProvider : public InputProvider{
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
    
    class  Device{
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
}

/* IR */
class  Ir{
	public:
        static void read();
        static void write();
};

/* Battery */
class  Battery{
	public:
        static bool isCharging();
        static float powerLevel();
};

/* Create */
typedef unsigned int speed_t;
#define PI 3.14159f

class  CreateScript{
	public:
        CreateScript();
        CreateScript(const CreateScript& rhs);
        
        void append(const unsigned char& byte);
        void append(const unsigned char *data, const size_t& size);
        void append(const CreateScript& script);
        
        void remove(const size_t& i, const size_t& len = 1);
        
        const unsigned char *data() const;
        size_t size() const;
        
        unsigned char byte(const size_t& i);
        
        CreateScript& operator=(const CreateScript& rhs);
        
	private:
        std::vector<unsigned char> m_script;
};

struct CreateState{
    timeval timestamp;

    int distance;
    int angle;
    short radius;
    short rightVelocity;
    short leftVelocity;
};

class  Create{
	public:

        enum Mode {
                OffMode,
                PassiveMode,
                SafeMode,
                FullMode
        };
        
        ~Create();
        
        bool connect();
        bool disconnect();
        bool isConnected() const;
        
        void setPassiveMode();
        void setSafeMode();
        void setFullMode();
        
        void setMode(const Create::Mode& mode);
        Create::Mode mode();
        
        void send(const CreateScript& script);
        
        bool write(const unsigned char& c);
        bool write(const unsigned char *data, const size_t& len);
        
        void flush();
        short read();
        int read(unsigned char *data, const size_t& len);
        bool blockingRead(unsigned char *data, const size_t& size, unsigned timeout = 25);
        
        template<typename T>
        inline bool blockingRead(T& data, unsigned timeout = 0){
            return blockingRead(reinterpret_cast<unsigned char *>(&data), sizeof(T),
                    timeout ? timeout : sizeof(T) * 7);
        }

        void setLeds(const bool& advance, const bool& play, const unsigned char& color, const unsigned char& brightness);

        void drive(const short& velocity, const short& radius);
        void driveDirect(const short& left, const short& right);
        void driveStraight(const short& speed);
        void stop();
        
        void turn(const short& angle, const unsigned short& speed);
        void move(const short& millimeters, const unsigned short& speed);
        void spin(const short& speed);
        short angularVelocity() const;
        
        void spinClockwise(const short& speed);
        void spinCounterClockwise(const short& speed);
        
        bool setBaudRate(const unsigned char& baudCode);
        
        void setDistance(const int distance);
        void setAngle(const int angle);
        
        AbstractButton *playButton() const;
        AbstractButton *advanceButton() const;

        Sensor<bool> *wall() const;
        Sensor<bool> *cliffLeft() const;
        Sensor<bool> *cliffFrontLeft() const;
        Sensor<bool> *cliffFrontRight() const;
        Sensor<bool> *cliffRight() const;
        Sensor<bool> *virtualWall() const;
        
        Sensor<unsigned short> *wallSignal() const;
        Sensor<unsigned short> *cliffLeftSignal() const;
        Sensor<unsigned short> *cliffFrontLeftSignal() const;
        Sensor<unsigned short> *cliffFrontRightSignal() const;
        Sensor<unsigned short> *cliffRightSignal() const;
        Sensor<unsigned short> *cargoBayAnalogSignal() const;
        Sensor<unsigned char> *cargoBayDigitalInputs() const;
        
        Sensor<unsigned char> *ir() const;
        
        Sensor<unsigned char> *chargingState() const;
        Sensor<char> *batteryTemperature() const;
        Sensor<unsigned short> *batteryCharge() const;
        Sensor<unsigned short> *batteryCapacity() const;
        
        Sensor<int> *angle() const;
        Sensor<int> *distance() const;
        
        Sensor<bool> *bumpLeft() const;
        Sensor<bool> *bumpRight() const;

        Sensor<bool> *wheelDropLeft() const;
        Sensor<bool> *wheelDropRight() const;
        Sensor<bool> *wheelDropCaster() const;

        void setRefreshRate(const unsigned short& refreshRate);
        const unsigned short& refreshRate() const;
        static Create *instance();
        
        const CreateState *state();
        
	private:
        Create();
        Create(const Create& rhs);
        Create& operator=(const Create& rhs);
        
        void setLocalBaudRate(const speed_t& baudRate);
        
        bool start();
        
        bool open();
        void close();
        
        template<typename T>
        inline void lazyDelete(T *&ptr){
                if(ptr) delete ptr;
        }
        
        inline timeval timeOfDay() const{
                timeval ret;
                gettimeofday(&ret, NULL);
                return ret;
        }
        
        inline bool hasRequiredTimePassed(const timeval& timestamp) const{
                return false;
        }

        inline double timevalToFloat(const timeval& tv){
            return ((double)tv.tv_sec) + ((double)tv.tv_usec / 1000000.0);
        }

        inline float deg2rad(const float& deg){
            return deg / 180.0 * PI;
        }

        void updateState();
        
        void updateSensorPacket1();
        void updateSensorPacket2(bool forceUpdate = false);
        void updateSensorPacket3();
        void updateSensorPacket4();
        void updateSensorPacket5();
        
        CreateState m_state;
        
        unsigned short m_refreshRate;
        
        CreatePackets::_1 m_1;
        CreatePackets::_2 m_2;
        CreatePackets::_3 m_3;
        CreatePackets::_4 m_4;
        CreatePackets::_5 m_5;
        timeval timestamps[5];

        mutable CreateSensors::PlayButton *m_playButton;
        mutable CreateSensors::AdvanceButton *m_advanceButton;

        mutable CreateSensors::Wall *m_wall;
        mutable CreateSensors::CliffLeft *m_cliffLeft;
        mutable CreateSensors::CliffFrontLeft *m_cliffFrontLeft;
        mutable CreateSensors::CliffFrontRight *m_cliffFrontRight;
        mutable CreateSensors::CliffRight *m_cliffRight;
        mutable CreateSensors::VirtualWall *m_virtualWall;

        mutable CreateSensors::WallSignal *m_wallSignal;
        mutable CreateSensors::CliffLeftSignal *m_cliffLeftSignal;
        mutable CreateSensors::CliffFrontLeftSignal *m_cliffFrontLeftSignal;
        mutable CreateSensors::CliffFrontRightSignal *m_cliffFrontRightSignal;
        mutable CreateSensors::CliffRightSignal *m_cliffRightSignal;
        mutable CreateSensors::CargoBayAnalogSignal *m_cargoBayAnalogSignal;
        mutable CreateSensors::CargoBayDigitalInputs *m_cargoBayDigitalInputs;
        
        mutable CreateSensors::IR *m_ir;
        
        mutable CreateSensors::ChargingState *m_chargingState;
        mutable CreateSensors::BatteryTemperature *m_batteryTemperature;
        mutable CreateSensors::BatteryCharge *m_batteryCharge;
        mutable CreateSensors::BatteryCapacity *m_batteryCapacity;
        
        mutable CreateSensors::Angle *m_angle;
        mutable CreateSensors::Distance *m_distance;
        
        mutable CreateSensors::BumpLeft *m_bumpLeft;
        mutable CreateSensors::BumpRight *m_bumpRight;

        mutable CreateSensors::WheelDropLeft *m_wheelDropLeft;
        mutable CreateSensors::WheelDropRight *m_wheelDropRight;
        mutable CreateSensors::WheelDropCaster *m_wheelDropCaster;

        size_t m_i;
        CreateScript m_script;
        int m_tty;
};

/* Console */
class  Console{
	public:
        static void clear();
};

/* Datalog */
class DataLog;

class  Category{
	public:
        void append(const std::string& data);
        void append(const double& data);
        
        void remove(const unsigned int& index);
        const std::vector<std::string>& entries() const;
        const std::string& name() const;
        
        friend class DataLog;
	private:
        Category(const std::string& name);
        
        std::string m_name;
        std::vector<std::string> m_entries;
};

class  DataLogWriter{
	public:
        virtual ~DataLogWriter();
        
        virtual bool write(const DataLog *dataLog) = 0;
};

class  CsvWriter : public DataLogWriter{
	public:
        CsvWriter(const std::string& path);
        virtual bool write(const DataLog *dataLog);
        
	private:
        std::string m_path;
};

class  PlainWriter : public DataLogWriter{
	public:
        PlainWriter(const std::string& path);
        virtual bool write(const DataLog *dataLog);
	private:
        unsigned int columnWidth(Category *category) const;
        
        std::string m_path;
};

class  DataLog{
	public:
        ~DataLog();
        Category *category(const std::string& name);
        void removeCategory(const std::string& name);
        std::vector<Category *> categories() const;
        bool write(DataLogWriter *writer) const;
        void clear();
	private:
        std::map<std::string, Category *> m_categories;
};

/* Accel */
class Acceleration{
	public:
        static short x();
        static short y();
        static short z();
        static bool calibrate();
	private:
        static void setupI2C();
        static bool s_setup;
};

class AccelX : public Sensor<short>{
	public:
        virtual short value() const;
};

class AccelY : public Sensor<short>{
	public:
        virtual short value() const;
};

class AccelZ : public Sensor<short>{
	public:
        virtual short value() const;
};
