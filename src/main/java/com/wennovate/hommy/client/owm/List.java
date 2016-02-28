
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class List extends JavaScriptObject {

	// private int dt;
	// private Temp temp;
	// private double pressure;
	// private int humidity;
	// private java.util.List<Weather> weather = new ArrayList<Weather>();
	// private double speed;
	// private int deg;
	// private int clouds;
	// private double rain;

	protected List() {
	}

	/**
	 * 
	 * @return The dt
	 */
	public final native int getDt() /*-{
		return this.dt;
	}-*/;

	/**
	 * 
	 * @return The temp
	 */
	public final native Temp getTemp() /*-{
		return this.temp;
	}-*/;

	/**
	 * 
	 * @return The pressure
	 */
	public final native double getPressure() /*-{
		return this.pressure;
	}-*/;

	/**
	 * 
	 * @return The humidity
	 */
	public final native int getHumidity() /*-{
		return this.humidity;
	}-*/;

	/**
	 * 
	 * @return The weather
	 */
	public final native JsArray<Weather> getWeather() /*-{
		return this.weather;
	}-*/;

	/**
	 * 
	 * @return The speed
	 */
	public final native double getSpeed() /*-{
		return this.speed;
	}-*/;

	/**
	 * 
	 * @return The deg
	 */
	public final native int getDeg() /*-{
		return this.deg;
	}-*/;

	/**
	 * 
	 * @return The clouds
	 */
	public final native int getClouds() /*-{
		return this.clouds;
	}-*/;

	/**
	 * 
	 * @return The rain
	 */
	public final native double getRain() /*-{
		return this.rain;
	}-*/;

}
