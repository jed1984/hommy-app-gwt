
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Clouds extends JavaScriptObject {

	// private int all;
	// private Map<String, Object> additionalProperties = new HashMap<String,
	// Object>();

	protected Clouds() {
	}

	/**
	 * @return The all
	 */
	public final native int getAll() /*-{
		return this.all;
	}-*/;

	// public final native Map<String, Object> getAdditionalProperties() /*-{
	// return this.this.additionalProperties;
	// }-*/;
}
