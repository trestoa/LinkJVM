package linkjvm.high.camera;

public final class CameraResolution {
	private int width, height;

	public static final CameraResolution lowResolution = new CameraResolution(160, 120);
	public static final CameraResolution medResolution = new CameraResolution(320, 240);
	public static final CameraResolution highResolution = new CameraResolution(640, 480);

	public CameraResolution(int width, int height){
		this.width = width;
		this.height = height;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}
}
