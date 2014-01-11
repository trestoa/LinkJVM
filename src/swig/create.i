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

%module linkjvm_create

%{
    #include <time.h>
    typedef unsigned int speed_t;
    #include <cstdio>
    #include <cstdlib>
    #include <vector>
    #include "include/kovan/sensor.hpp"
    #include "include/kovan/button.hpp"
    #include "include/kovan/create.hpp"
    #define PI 3.14159f
%}

%include "stl.i"

typedef unsigned int speed_t;

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
