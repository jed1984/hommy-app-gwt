package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Rain extends JavaScriptObject {

	// private int 3h;

	protected Rain() {
	}
	
	// FIXME cannot be used cause we cannot parse a 3h field
	/**
	 * @return The rain in last 3h
	 */
	public final native int get3H() /*-{
		return 0;
	}-*/;
}
