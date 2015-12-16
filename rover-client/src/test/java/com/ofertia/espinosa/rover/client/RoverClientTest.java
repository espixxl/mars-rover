package com.ofertia.espinosa.rover.client;

import org.junit.Test;

import com.ofertia.espinosa.rover.client.utils.RoverClientUtils;

import static org.junit.Assert.*;

/**
 * The Class RoverClientTest.
 * 
 * @author David Espinosa
 */
public class RoverClientTest {
	
	/**
	 * When input size is incorrect error is returned.
	 */
	@Test
	public void whenInputSizeIsIncorrectErrorIsReturned() {
		String args[] = new String[1];
		args[0] = "GET";		
		assertFalse(RoverClientUtils.checkInput(args));
	}
	
	/**
	 * When input protocol is incorrect error is returned.
	 */
	@Test
	public void whenInputProtocolIsIncorrectErrorIsReturned() {
		String args[] = new String[2];
		args[0] = "GETA";		
		args[1] = "http://localhost:80";
		assertFalse(RoverClientUtils.checkInput(args));
	}
	
	/**
	 * When input url is invalid error is returned.
	 */
	@Test
	public void whenInputUrlIsInvalidErrorIsReturned() {
		String args[] = new String[2];
		args[0] = "GET";		
		args[1] = "nohttp://localhost:80";
		assertFalse(RoverClientUtils.checkInput(args));
	}
	
	/**
	 * When input is correct no error is returned.
	 */
	@Test
	public void whenInputIsCorrectNoErrorIsReturned() {
		String args[] = new String[2];
		args[0] = "GET";		
		args[1] = "http://localhost:80";
		assertTrue(RoverClientUtils.checkInput(args));
	}
}
