package linkjvm;

public class Botball {
	public static void msleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) { }
	}
}
