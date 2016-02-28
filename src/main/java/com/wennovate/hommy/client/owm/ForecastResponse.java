
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ForecastResponse extends JavaScriptObject{

	// private City city;
	// private String cod;
	// private double message;
	// private int cnt;
	// private java.util.List<com.wennovate.hommy.client.owm.List> list = new
	// ArrayList<com.wennovate.hommy.client.owm.List>();

	protected ForecastResponse() {
	}

	/**
	 * 
	 * @return The city
	 */
	public final native City getCity() /*-{
		return this.city;
	}-*/;

	/**
	 * 
	 * @return The cod
	 */
	public final native String getCod() /*-{
		return this.cod;
	}-*/;

	/**
	 * 
	 * @return The message
	 */
	public final native double getMessage() /*-{
		return this.message;
	}-*/;

	/**
	 * 
	 * @return The cnt
	 */
	public final native int getCnt() /*-{
		return this.cnt;
	}-*/;

	/**
	 * 
	 * @return The list
	 */
	public final native JsArray<List> getList() /*-{
		return this.list;
	}-*/;

}
