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

%module linkjvm_motor
%{
    #include "include/kovan/port.hpp"
    #include "include/kovan/sensor.hpp"
}

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