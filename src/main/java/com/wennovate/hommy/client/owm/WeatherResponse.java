
package com.wennovate.hommy.client.owm;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class WeatherResponse extends JavaScriptObject {

	// private Coord coord;
	// private List<Weather> weather = new ArrayList<Weather>();
	// private String base;
	// private Main main;
	// private Wind wind;
	// private Clouds clouds;
	// private int dt;
	// private Sys sys;
	// private int id;
	// private String name;
	// private int cod;
	
	protected WeatherResponse() {
	}

	/**
	 * @return The coord
	 */
	public final native Coord getCoord() /*-{
		return this.coord;
	}-*/;

	/**
	 * @return The weather
	 */
	public final native JsArray<Weather> getWeather() /*-{
		return this.weather;
	}-*/;

	/**
	 * @return The base
	 */
	public final native String getBase() /*-{
		return this.base;
	}-*/;

	/**
	 * @return The main
	 */
	public final native Main getMain() /*-{
		return this.main;
	}-*/;

	/**
	 * @return The wind
	 */
	public final native Wind getWind() /*-{
		return this.wind;
	}-*/;

	/**
	 * @return The clouds
	 */
	public final native Clouds getClouds() /*-{
		return this.clouds;
	}-*/;

	/**
	 * @return The dt
	 */
	public final native int getDt() /*-{
		return this.dt;
	}-*/;

	/**
	 * @return The sys
	 */
	public final native Sys getSys() /*-{
		return this.sys;
	}-*/;

	/**
	 * @return The id
	 */
	public final native int getId() /*-{
		return this.id;
	}-*/;

	/**
	 * @return The name
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;

	/**
	 * @return The cod
	 */
	public final native int getCod() /*-{
		return this.cod;
	}-*/;


}
