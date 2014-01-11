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
public class Object {
	private final Rectangle boundingBox;
	private final Point2 centroid;
	private final double confidence;
	
	Object(Rectangle boundingBox, Point2 centroid, double confidence) {
		super();
		this.boundingBox = boundingBox;
		this.centroid = centroid;
		this.confidence = confidence;
	}

	/**
	 * @return the boundingBox
	 */
	public synchronized Rectangle getBoundingBox() {
		return boundingBox;
	}

	/**
	 * @return the centroid
	 */
	public synchronized Point2 getCentroid() {
		return centroid;
	}

	/**
	 * @return the confidence
	 */
	public synchronized double getConfidence() {
		return confidence;
	}
	
	
}
