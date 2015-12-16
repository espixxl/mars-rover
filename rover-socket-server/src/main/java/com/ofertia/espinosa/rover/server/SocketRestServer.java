package com.ofertia.espinosa.rover.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;

import com.ofertia.espinosa.rover.domain.Mars;
import com.ofertia.espinosa.rover.domain.Rover;
import com.orfertia.espinosa.rover.actuator.MarsActuator;
import com.orfertia.espinosa.rover.exception.CollisionException;
import com.orfertia.espinosa.rover.utils.InputUtils;

/**
 * The Class SocketRestServer.
 * 
 * @author David Espinosa
 */
public class SocketRestServer {

	/** The port. */
	private int port;
	
	/** The retries. */
	private int retries;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String args[]) {
		
		try {
			if ((args == null)||(args.length<2)) {
				SocketRestServer.printHelp();
			} else {
				int port = Integer.valueOf(args[0]);
				int retries = Integer.valueOf(args[1]);
				SocketRestServer socketRestServer = new SocketRestServer(port, retries);
				socketRestServer.runServer();
			}
		} catch (final Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * Instantiates a new socket rest server.
	 *
	 * @param port the port
	 * @param retries the retries
	 */
	public SocketRestServer(int port, int retries) {
		this.port = port;
		this.retries = retries;
	}
	
	/**
	 * Run server.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws Exception the exception
	 * @throws CollisionException the collision exception
	 */
	public void runServer()
			throws IOException, UnsupportedEncodingException, Exception, CollisionException {
		
		System.out.println("\nSocket Rover Server started at port: "+this.port);
		System.out.println("This server will attend "+this.retries+" requests before turning off.");
		System.out.println("\n-----------------------------------------------------------------------\n");
		final ServerSocket ss = new ServerSocket(this.port);

		for (int i=0;i<retries;i++) {
			final Socket client = ss.accept();

			final BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			final PrintWriter out = new PrintWriter(client.getOutputStream());

			out.print("HTTP/1.1 200 \r\n");
			out.print("Content-Type: text/plain\r\n");
			out.print("Connection: close\r\n");
			out.print("\r\n");

			String testInput = in.readLine();
			testInput = testInput.split("mars=")[1];
			testInput = testInput.split(" ")[0];
			testInput = URLDecoder.decode(testInput, "UTF-8");

			Mars mars = InputUtils.createMarsFromInputLine(testInput);
			MarsActuator marsActuator = new MarsActuator(mars);
			for (Rover rover : mars.getRovers().values()) {
				marsActuator.moveRover(rover.getRoverId(), rover.getRoverMovementSequence());
			}
			String testResult = InputUtils.createOutputLine(new ArrayList<Rover>(mars.getRovers().values()));
			out.println(testResult);

			out.close();
			in.close();
			client.close();
			System.out.println("Request received: "+testInput);
			System.out.println("Response sent: "+testResult);
			System.out.println((retries-(i+1))+" request retries left to attend.\n ");
		}
		ss.close();
		System.out.println("\n-----------------------------------------------------------------------\n");
		System.out.print("Socket Rest Server ending after "+retries+ " retries. Good Rovers!");
	}
	
    /**
     * Prints the help.
     */
    public static void printHelp() {
    	System.out.println("Syntax: java -jar roverRestServer-jar-with-dependencies.jar [port] [retries]");
    	System.out.println("for example:");
    	System.out.println("\t java -jar socketRestServer.jar 80 2");
    	System.out.println("Send mail to espinosa.eduard@gmail.com for further information.");
    }
}
