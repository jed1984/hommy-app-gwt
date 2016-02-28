
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Wind extends JavaScriptObject {

	// private float speed;
	// private float deg;

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

}
