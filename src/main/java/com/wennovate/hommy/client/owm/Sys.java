
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Sys extends JavaScriptObject {

	// private float message;
	// private String country;
	// private int sunrise;
	// private int sunset;

	protected Sys() {
	}

	/**
	 * 
	 * @return The message
	 */
	public final native float getMessage() /*-{
		return this.message;
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
	 * @return The sunrise
	 */
	public final native int getSunrise() /*-{
		return this.sunrise;
	}-*/;

	/**
	 * 
	 * @return The sunset
	 */
	public final native int getSunset() /*-{
		return this.sunset;
	}-*/;


}
