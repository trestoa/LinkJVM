package linkjvm.high.vision;

public class Point2 {
	private int x;
	private int y;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Point2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public synchronized int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public synchronized void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public synchronized int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public synchronized void setY(int y) {
		this.y = y;
	}
	
}
