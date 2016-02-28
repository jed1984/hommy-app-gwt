
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Coord extends JavaScriptObject {

	// private float lon;
	// private float lat;
	// private Map<String, Object> additionalProperties = new HashMap<String,
	// Object>();

	protected Coord() {
	}

	/**
	 * @return The lon
	 */
	public final native float getLon() /*-{
		 return this.lon;
	}-*/;

	/**
	 * @return The lat
	 */
	public final native float getLat() /*-{
		 return this.lat;
	}-*/;

	// public final native Map<String, Object> getAdditionalProperties() /*-{
	// return this.additionalProperties;
	// }-*/;

}
