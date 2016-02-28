
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Temp extends JavaScriptObject {

	// private double day;
	// private double min;
	// private double max;
	// private double night;
	// private double eve;
	// private double morn;

	protected Temp() {
	}

	/**
	 * 
	 * @return The day
	 */
	public final native double getDay() /*-{
		return this.day;
	}-*/;

	/**
	 * 
	 * @return The min
	 */
	public final native double getMin() /*-{
		return this.min;
	}-*/;

	/**
	 * 
	 * @return The max
	 */
	public final native double getMax() /*-{
		return this.max;
	}-*/;

	/**
	 * 
	 * @return The night
	 */
	public final native double getNight() /*-{
		return this.night;
	}-*/;

	/**
	 * 
	 * @return The eve
	 */
	public final native double getEve() /*-{
		return this.eve;
	}-*/;

	/**
	 * 
	 * @return The morn
	 */
	public final native double getMorn() /*-{
		return this.morn;
	}-*/;

}
