package linkjvm.high.debugger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 
 * @author Markus Klein
 *
 */
public class Debugger {
	private Socket socket;
	private PrintWriter writer = null;
	
	/**
	 * 
	 */
	public Debugger(){
		socket = new Socket();
	}
	
	/**
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public boolean connect(String host, int port){
		try {
			socket.connect(new InetSocketAddress(host, port));
			writer = new PrintWriter(socket.getOutputStream());
			return true;
		} catch (IOException e) {
			System.out.println("Could not connect to " + host  + ":" + port + ".");
			return false;
		}
	}
	
	/**
	 * 
	 */
	public void close(){
		try {
			writer.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Cloud not close socket.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param text
	 */
	public boolean writeln(String text){
		return write(text + "\n");
	}
	
	/**
	 * 
	 * @param text
	 */
	public boolean write(String text){
		if(!socket.isClosed() && writer != null){
			writer.print(text);
			return true;
		}
		else{
			System.out.println("Not connected to a server or connection is closed.");
			return false;
		}
	}
}
