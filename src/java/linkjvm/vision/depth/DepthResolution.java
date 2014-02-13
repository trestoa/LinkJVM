package linkjvm.vision.depth;

/**
 * 
 * @author Markus Klein
 *
 */
public enum DepthResolution {
	LOW_RES(320, 240),
	HIGH_RES(640, 480);
		
	public int width;
	public int height;
	
	private DepthResolution(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
}
