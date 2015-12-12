package com.ofertia.espinosa.rover.domain;

/**
 * The Class RoverPlateau.
 * 
 * @author David Espinosa
 */
public class Plateau {
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	/**
	 * Instantiates a new rover plateau.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public Plateau(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
