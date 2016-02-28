
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class City extends JavaScriptObject {

	// private int id;
	// private String name;
	// private Coord coord;
	// private String country;
	// private int population;

	protected City() {
	}

	/**
	 * 
	 * @return The id
	 */
	public final native int getId() /*-{
		return this.id;
	}-*/;

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public final native void setId(int id) /*-{
		this.id = id;
	}-*/;

	/**
	 * 
	 * @return The name
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;

	/**
	 * 
	 * @return The coord
	 */
	public final native Coord getCoord() /*-{
		return this.coord;
	}-*/;

	/**
	 * 
	 * @return The country
	 */
	public final native String getCountry() /*-{
		return this.country;
	}-*/;

	/**
	 * 
	 * @return The population
	 */
	public final native int getPopulation() /*-{
		return this.population;
	}-*/;

}
