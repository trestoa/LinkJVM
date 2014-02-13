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

package linkjvm.vision;

/**
 * An instance of this class represents an object which has been tracked by an {@link ImageProcessor}.
 * @author Markus Klein
 * @version 2.1.0
 * @since 2.0.0
 */
public class CameraObject {
	private final Rectangle boundingBox;
	private final Point2 centroid;
	private final double confidence;
	
	CameraObject(Rectangle boundingBox, Point2 centroid, double confidence) {
		super();
		this.boundingBox = boundingBox;
		this.centroid = centroid;
		this.confidence = confidence;
	}

	/**
	 * Returns the bounding box of this object.
	 * @return bounding box
	 */
	public synchronized Rectangle getBoundingBox() {
		return boundingBox;
	}

	/**
	 * Returns the centroid of this object.
	 * @return centroid
	 */
	public synchronized Point2 getCentroid() {
		return centroid;
	}

	/**
	 * Returns the confidence of this object.
	 * @return confidence
	 */
	public synchronized double getConfidence() {
		return confidence;
	}
	
	
}
