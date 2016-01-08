package com.espinosa.rover.client.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * The Class RoverClientUtils.
 * 
 * @author David Espinosa
 */
public class RoverClientUtils {

	/** The Constant GET_REQUEST. */
	public static final String GET_REQUEST = "GET";
	
	/** The Constant POST_REQUEST. */
	public static final String POST_REQUEST = "POST";
	
	/**
	 * Checks if is valid url.
	 *
	 * @param urlStr the url str
	 * @return true, if is valid url
	 */
	public static boolean isValidURL(final String urlStr) {
		boolean validUrl = false;
	    try {
	    	@SuppressWarnings("unused")
	        final URL url = new URL(urlStr);
	    	validUrl = true;
	    } catch (final MalformedURLException e) {
	    	validUrl = false;
	    }
	    return validUrl;
	}

	/**
	 * Check input.
	 *
	 * @param args the args
	 * @return true, if successful
	 */
	public static boolean checkInput(final String args[]) {
	    
		boolean validUrl = false;
		boolean validProtocol = false;
		boolean checkArgsLength = (args!=null)&&(args.length>=2);
		if (checkArgsLength) {
			 if ((RoverClientUtils.GET_REQUEST.equals(args[0])||(RoverClientUtils.POST_REQUEST.equals(args[0])))) {
				 validProtocol = true;
			 } 
			 if (isValidURL(args[1])) {
				 validUrl = true;
			 }
		}
	    return (validProtocol&&validUrl);
	}
	
	/**
	 * Gets the params from console.
	 *
	 * @return the params from console
	 */
	public static String getParamsFromConsole() {
		System.out.println("Test Input: ");
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		in.close();
		return line;
	}
}