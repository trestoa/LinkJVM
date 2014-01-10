package linkjvm.high.vision;

/**
 * 
 * @author Markus Klein
 *
 */
public class Rectangle {
	private long width;
	private long height;
	private long x;
	private long y;
	
	private Point2 center;

	/**
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 * @param center
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
	 * @return the width
	 */
	public synchronized long getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public synchronized void setWidth(long width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public synchronized long getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public synchronized void setHeight(long height) {
		this.height = height;
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
	 * @return the center
	 */
	public synchronized Point2 getCenter() {
		return center;
	}

	/**
	 * @param center the center to set
	 */
	public synchronized void setCenter(Point2 center) {
		this.center = center;
	}
	
	/**
	 * 
	 * @return
	 */
	public long getArea(){
		return width * height;
	}	
}
