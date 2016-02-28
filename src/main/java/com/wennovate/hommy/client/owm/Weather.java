
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Weather extends JavaScriptObject {

	// private int id;
	// private String main;
	// private String description;
	// private String icon;
	// private Map<String, Object> additionalProperties = new HashMap<String,
	// Object>();

	protected Weather() {
	}

	/**
	 * @return The id
	 */
	public final native int getId() /*-{
		return this.id;
	}-*/;

	/**
	 * 
	 * @return The main
	 */
	public final native String getMain() /*-{
		return this.main;
	}-*/;

	/**
	 * 
	 * @return The description
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;

	/**
	 * 
	 * @return The icon
	 */
	public final native String getIcon() /*-{
		return this.icon;
	}-*/;

	// public final native Map<String, Object> getAdditionalProperties() /*-{
	// return this.additionalProperties;
	// }-*/

}
