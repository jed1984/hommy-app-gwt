
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Clouds extends JavaScriptObject {

	// private int all;
	
	protected Clouds() {
	}

	/**
	 * @return The all
	 */
	public final native int getAll() /*-{
		return this.all;
	}-*/;

}
