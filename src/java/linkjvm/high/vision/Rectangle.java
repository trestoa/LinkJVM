/*
 * This file is part of LinkJVM.
 *
 * Java Framework for the KIPR Link
 * Copyright (C) 2014 LinkJVM
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

package linkjvm.high.vision;

/**
 * This class represents an rectangle.
 * @author Markus Klein
 * @version 2.0.0
 * @since 2.0.0
 */
public class Rectangle {
	private long width;
	private long height;
	private long x;
	private long y;
	
	private Point2 center;

	/**
	 * Constructs a new rectangle with the specified values.
	 * @param width width
	 * @param height height
	 * @param x x position
	 * @param y y position
	 * @param center center
	 */
	public Rectangle(long width, long height, long x, long y, Point2 center) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.center = center;
	}

	/**
	 * Returns the rectangle's width.
	 * @return width
	 */
	public synchronized long getWidth() {
		return width;
	}

	/**
	 * Sets the rectangle's width.
	 * @param width width
	 */
	public synchronized void setWidth(long width) {
		this.width = width;
	}

	/**
	 * Returns the rectangle's Height.
	 * @return height
	 */
	public synchronized long getHeight() {
		return height;
	}

	/**
	 * Sets the rectangle's height.
	 * @param height height
	 */
	public synchronized void setHeight(long height) {
		this.height = height;
	}
	
	/**
	 * Returns the rectangle's x position.
	 * @return x position
	 */
	public synchronized long getX() {
		return x;
	}

	/**
	 * Sets the rectangle's x position.
	 * @param x x position
	 */
	public synchronized void setX(long x) {
		this.x = x;
	}

	/**
	 * Returns the rectangle's y position.
	 * @return y position
	 */
	public synchronized long getY() {
		return y;
	}

	/**
	 * Sets the rectangle's y position.
	 * @param y y position
	 */
	public synchronized void setY(long y) {
		this.y = y;
	}

	/**
	 * Returns the rectangle's center position.
	 * @return center point
	 */
	public synchronized Point2 getCenter() {
		return center;
	}

	/**
	 * Sets the rectangle's center position.
	 * @param center center point
	 */
	public synchronized void setCenter(Point2 center) {
		this.center = center;
	}
	
	/**
	 * Returns the rectangles area.
	 * @return area
	 */
	public long getArea(){
		return width * height;
	}	
}
