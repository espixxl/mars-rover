package com.ofertia.espinosa.rover.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The Class RoverClient.
 */
public class RoverClient {

    private static final String GET_REQUEST = "GET";
    private static final String POST_REQUEST = "POST";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String args[]) {
        
        final RoverClient roverClient = new RoverClient();
        

        
        final String requestType;

        try {
            roverClient.test();
            final String retorn = roverClient.httpGet("http://localhost:80/5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
            System.out.println(retorn);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Send get request.
     */
    public void sendGetRequest() {

    }

    /**
     * Send post request.
     */
    public void sendPostRequest() {

    }

    /**
     * Prints the help.
     */
    public void printHelp() {

    }

    public boolean checkInput(final String args[]) {
        
    	boolean validUrl = false;
    	boolean validProtocol = false;
    	boolean checkArgsLength = (args!=null)&&(args.length>=2);
    	if (checkArgsLength) {
    		 if ((GET_REQUEST.equals(args[0])||(POST_REQUEST.equals(args[0])))) {
    			 validProtocol = true;
    		 } 
    		 if (isValidURL(args[1])) {
    			 validUrl = true;
    		 }
    	}
        return (validProtocol&&validUrl);
    }

    public boolean isValidURL(final String urlStr) {
        try {
            final URL url = new URL(urlStr);
            return true;
        } catch (final MalformedURLException e) {
            return false;
        }
    }

    /**
     * Http get.
     *
     * @param urlStr the url str
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public String httpGet(final String urlStr) throws IOException {

        final URL url = new URL(urlStr);
        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // if (conn.getResponseCode() != 200) {
        // throw new IOException(conn.getResponseMessage());
        // }

        // Buffer the result into a string
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
     * Test.
     *
     * @throws Exception the exception
     */
    public void test() throws Exception {
        final String url = "http://localhost:80/5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";

        final URL obj = new URL(url);
        final HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        // add request header
        con.setRequestProperty("User-Agent", "Chrome");

        final int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        final StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
        System.out.println(response.toString());
    }
}
