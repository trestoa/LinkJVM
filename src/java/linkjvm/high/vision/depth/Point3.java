package linkjvm.high.vision.depth;

/**
 * 
 * @author Markus Klein
 *
 */
public class Point3 {
	private long x;
	private long y;
	private long z;
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3(long x, long y, long z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
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

	/**
	 * @return the z
	 */
	public synchronized long getZ() {
		return z;
	}

	/**
	 * @param z the z to set
	 */
	public synchronized void setZ(long z) {
		this.z = z;
	}
	

}
