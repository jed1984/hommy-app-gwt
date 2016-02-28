
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Wind extends JavaScriptObject {

	// private float speed;
	// private float deg;
	// private Map<String, Object> additionalProperties = new HashMap<String,
	// Object>();

	protected Wind() {
	}

	/**
	 * @return The speed
	 */
	public final native float getSpeed() /*-{
		return this.speed;
	}-*/;

	/**
	 * @return The deg
	 */
	public final native float getDeg() /*-{
		return this.deg;
	}-*/;

	// public final native Map<String, Object> getAdditionalProperties() /*-{
	// return this.additionalProperties;
	// }-*/;

}
