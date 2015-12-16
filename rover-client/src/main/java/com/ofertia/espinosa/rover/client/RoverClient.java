package com.ofertia.espinosa.rover.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import com.ofertia.espinosa.rover.client.utils.RoverClientUtils;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.jaxb.request.MarsRequest;
import com.ofertia.espinosa.rover.jaxb.response.MarsResponse;
import com.orfertia.espinosa.rover.utils.InputUtils;
import com.orfertia.espinosa.rover.xml.MarsMarshallerUtils;
import com.orfertia.espinosa.rover.xml.XmlUtils;

/**
 * The Class RoverClient.
 * 
 * @author David Espinosa
 */
public class RoverClient {

	/**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String args[]) {

        if (RoverClientUtils.checkInput(args)) {
	        final String requestType = args[0];
	        String url = args[1];
	        String params = RoverClientUtils.getParamsFromConsole();
	        
	        switch (requestType) {
			case RoverClientUtils.GET_REQUEST:
				try {
					System.out.println("Test Output:"+RoverClient.sendGetRequest(url, params));
				} catch (IOException e) {
					System.out.println("Error in get request!"+e.getMessage());
				}
				break;
			case RoverClientUtils.POST_REQUEST:
				try {
					System.out.println("Test Output:"+RoverClient.sendPostRequest(url, params));					
				} catch (Exception e) {
					System.out.println("Error in post request!"+e.getMessage());
				}
				break;
			default:
				break;
			}
        } else {
        	RoverClient.printHelp();
        }
    }

    /**
     * Send get request.
     *
     * @param urlStr the url str
     * @param params the params
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static String sendGetRequest(String urlStr, String params) throws IOException {
    	
    	urlStr = urlStr+"?mars="+URLEncoder.encode(params, "UTF-8");
        final URL url = new URL(urlStr);
        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        final StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        return sb.toString();
    }

    /**
     * Post request.
     *
     * @param urlStr the url str
     * @param marsInputLine the mars input line
     * @return the string
     * @throws Exception the exception
     */
    public static String getPostRequestResponse(String urlStr, String marsInputLine) throws Exception {
    	
    	String unmarshalledMarsResponse = "";
		URL url = new URL(urlStr);
	    URLConnection conn = url.openConnection();
	    conn.setDoOutput(true);
	    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());	
	    writer.write(marsInputLine);
	    writer.flush();
	    String line;
	    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));	    
	    while ((line = reader.readLine()) != null) {
	    	unmarshalledMarsResponse += (line);
	    }
	    writer.close();
	    reader.close();
	    
    	return unmarshalledMarsResponse;
    }
    
    /**
     * Send post request.
     *
     * @param url the url
     * @param marsInputLine the mars input line
     * @return the string
     * @throws Exception the exception
     */
    public static String sendPostRequest(String url, String marsInputLine) throws Exception {

		MarsRequest marsRequest = XmlUtils.createMarsRequestFromInputLine(marsInputLine);
		String marshalledMars = MarsMarshallerUtils.marshalMarsRequest(marsRequest);    	
    	String message = getPostRequestResponse(url, marshalledMars);		
		MarsResponse marsResponse = MarsMarshallerUtils.unmarshalMarsResponse(new ByteArrayInputStream(message.getBytes("UTF-8")));
		List<Rover> rovers = XmlUtils.createRoversFromMarsResponse(marsResponse);
		
		return InputUtils.createOutputLine(rovers);
    }


    /**
     * Prints the help.
     */
    public static void printHelp() {
    	System.out.println("Syntax: java -jar roverClient-jar-with-dependencies.jar [connectiontype] [serviceurl]");
    	System.out.println("where options are:");
    	System.out.println("\t connectiontype:[GET|POST]");
    	System.out.println("\t url:[http://localhost:80|http://http://localhost:8080/rover-rest-server/RestServer]");
    	System.out.println("Send mail to: espinosa.eduard@gmail.com for further information.");
    }
}
