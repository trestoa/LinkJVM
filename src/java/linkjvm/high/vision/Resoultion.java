package linkjvm.high.vision;

public enum Resoultion {

	LOW_RES(160, 120),
	MED_RES(320, 240),
	HIGH_RES(640, 480);
		
	public int width;
	public int height;
	
	private Resoultion(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
}
