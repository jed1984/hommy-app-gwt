
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;

public class Main extends JavaScriptObject {

	// private float temp;
	// private float pressure;
	// private int humidity;
	// private float tempMin;
	// private float tempMax;
	// private float seaLevel;
	// private float grndLevel;
	// private Map<String, Object> additionalProperties = new HashMap<String,
	// Object>();
	
	protected Main() {
	}

	/**
	 * @return The temp
	 */
	public final native float getTemp() /*-{
		return this.temp;
	}-*/;

	/**
	 * @return The pressure
	 */
	public final native float getPressure() /*-{
		return this.pressure;
	}-*/;

	/**
	 * @return The humidity
	 */
	public final native int getHumidity() /*-{
		return this.humidity;
	}-*/;

	/**
	 * @return The tempMin
	 */
	public final native float getTempMin() /*-{
		return this.tempMin;
	}-*/;

	/**
	 * @return The tempMax
	 */
	public final native float getTempMax() /*-{
		return this.tempMax;
	}-*/;

	/**
	 * @return The seaLevel
	 */
	public final native float getSeaLevel() /*-{
		return this.seaLevel;
	}-*/;

	/**
	 * @return The grndLevel
	 */
	public final native float getGrndLevel() /*-{
		return this.grndLevel;
	}-*/;

	// public final native Map<String, Object> getAdditionalProperties() /*-{
	// return this.this.additionalProperties;
	// }-*/;

}
