package linkjvm.debugger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * The LinkJVM-Debugger is used to send bug information to a LinkJVM-Debugger-Client 
 * which receives the message in displays it.
 * @author Markus Klein
 * @version 2.1.0
 * @since 2.0.0
 */
public class Debugger {	
	public static final int DEFAULT_PORT = 62512;
	
	private Socket socket;
	private PrintWriter writer = null;
	
	/**
	 * Constructs a new debugger.
	 */
	public Debugger(){
		socket = new Socket();
	}
	
	/**
	 * Construct a new debugger and establish a connection to the given host.
	 * The invocation is the same as:
	 * <code>
	 * Debugger debugger = new Debugger();
	 * debugger.connect(host);
	 * </code>
	 * @param host IP-address of the debugger client.
	 */
	public Debugger(String host){
		this(host, DEFAULT_PORT);
	}
	
	/**
	 * Construct a new debugger and establish a connection to the given host and TCP port.
	 * The invocation is the same as:
	 * <code>
	 * Debugger debugger = new Debugger();
	 * debugger.connect(host, port);
	 * </code>
	 * @param host IP-address of the debugger client
	 * @param port TCP where the debugger client run
	 */
	public Debugger(String host, int port){
		socket = new Socket();
		connect(host, port);
	}
	
	/**
	 * Establish a connection to the given host.
	 * @param host IP-address of the debugger client.
	 * @return <code>true</code> on success and <code>false</code> on failure.
	 */
	public boolean connect(String host){
		return connect(host);
	}
	
	/**
	 * Establish a connection to the given host and TCP port.
	 * @param host IP-address of the debugger client
	 * @param port TCP where the debugger client run
	 * @return <code>true</code> on success and <code>false</code> on failure.
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
	 * Closes the connection to the client.
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
	 * Sends a debug message to the client and adds a new-line at the end of the message.
	 * @param text message to send
	 */
	public boolean writeln(String text){
		return write(text + "\n");
	}
	
	/**
	 * Sends a debug message to the client.
	 * @param text message to send
	 */
	public boolean write(String text){
		if(!socket.isClosed() && writer != null){
			writer.print(text);
			writer.flush();
			return true;
		}
		else{
			System.out.println("Not connected to a server or connection is closed.");
			return false;
		}
	}
}
