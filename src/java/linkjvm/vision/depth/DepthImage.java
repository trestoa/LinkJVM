package linkjvm.vision.depth;

import linkjvm.low.vision.IntPoint3;

/**
 * 
 * @author Markus Klein
 *
 */
public class DepthImage {
	private linkjvm.low.vision.DepthImage jniImage;
	
	/**
	 * 
	 * @param jniImage
	 */
	public DepthImage(linkjvm.low.vision.DepthImage jniImage) {
		this.jniImage = jniImage;
	}
	
	/**
	 * 
	 * @param orientation
	 */
	public void setOrientation(int orientation){
		jniImage.setOrientation(orientation);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getOrientation(){
		return jniImage.orientation();
	}
	
	/**
	 * 
	 * @return
	 */
	public long getHeight(){
		return jniImage.height();
	}
	
	/**
	 * 
	 * @return
	 */
	public long getWidth(){
		return jniImage.width();
	}
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public int depthAt(long row, long column){
		return jniImage.depthAt(row, column);
	}
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public Point3 pointAt(long row, long column){
		return toHighPoint3(jniImage.pointAt(row, column));
	}
	
	/**
	 * 
	 * @param jniPoint
	 * @return
	 */
	private Point3 toHighPoint3(IntPoint3 jniPoint){
		return new Point3(jniPoint.x(), jniPoint.y(), jniPoint.z());
	}
}