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

%module linkjvm_geom

typedef struct point2
{
        int x;
        int y;
} point2;

typedef struct rectangle
{
        int ulx;
        int uly;
        int width;
        int height;
} rectangle;

template<typename T>
class Point2
{
public:
        Point2(const T& x, const T &y)
                : m_x(x),
                m_y(y)
        {
        }

        const T &x() const
        {
                return m_x;
        }

        const T &y() const
        {
                return m_y;
        }

        void setX(const T &x)
        {
                m_x = x;
        }

        void setY(const T &y)
        {
                m_y = y;
        }

        point2 toCPoint2() const
        {
                return create_point2(m_x, m_y);
        }

private:
        T m_x;
        T m_y;
};

template<typename T>
class Rect{
    public:
        Rect(const T &x, const T &y, const T &width, const T &height)
                : m_x(x),
                m_y(y),
                m_width(width),
                m_height(height){
        }

        const T &x() const{
                return m_x;
        }

        const T &y() const{
                return m_y;
        }

        const T &width() const{
                return m_width;
        }

        const T &height() const{
                return m_height;
        }

        Point2<T> center() const{
                return Point2<T>(m_x + m_width / 2, m_y + m_height / 2);
        }

        void setX(const T &x){
                m_x = x;
        }

        void setY(const T &y){
                m_y = y;
        }

        void setWidth(const T &width){
                m_width = width;
        }

        void setHeight(const T &height){
                m_x = height;
        }

        T area() const{
                return m_width * m_height;
        }

        rectangle toCRectangle() const{
                return create_rectangle(m_x, m_y, m_width, m_height);
        }

    private:
        T m_x;
        T m_y;
        T m_width;
        T m_height;
};

/* instantaions */
%template(unsignedIntPoint2) Point2<unsigned int>;
%template(unsignedIntRect2) Rect<unsigned int>;

