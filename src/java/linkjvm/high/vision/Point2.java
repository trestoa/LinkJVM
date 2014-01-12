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
 * This class represents an 2 dimensional point
 * @author Markus Klein
 * @since 2.0.0
 * @version 2.0.0
 */
public class Point2 {
	private long x;
	private long y;
	
	/**
	 * Constructs a new Point with the specified coordinates.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Point2(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the point's x coordinate
	 */
	public synchronized long getX() {
		return x;
	}

	/**
	 * @param the point's x coordinate
	 */
	public synchronized void setX(long x) {
		this.x = x;
	}

	/**
	 * @return the point's y coordinate
	 */
	public synchronized long getY() {
		return y;
	}

	/**
	 * @param the point's y coordinate
	 */
	public synchronized void setY(long y) {
		this.y = y;
	}
	
}
