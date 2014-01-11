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
 * 
 * @author Markus Klein
 *
 */
public class Point2 {
	private long x;
	private long y;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Point2(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public synchronized long getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public synchronized void setX(long x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public synchronized long getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public synchronized void setY(long y) {
		this.y = y;
	}
	
}
