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

%module linkjvm_buttons
%{
    #include "include/kovan/sensor.hpp"
}

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

class  AbstractButton : public Sensor<bool>{
	pub
	    virtual void waitUntilClicked() const;
};lic:
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
