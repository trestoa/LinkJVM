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
