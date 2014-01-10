package linkjvm.high.vision;

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
