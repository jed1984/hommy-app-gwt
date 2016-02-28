package com.wennovate.hommy.client.owm;

import com.wennovate.hommy.client.network.HttpConnector;

public class WeatherApi {

	public static final String API_KEY = "0c84a7bca36ec85f31291354994eb62f";

	public static final String URL = "http://api.openweathermap.org/data/2.5/";

	public static final String CELSIUS_UNIT = "metric";
	public static final String FAHRENHEIT_UNIT = "imperial";
	public static final String JSON_MODE = "json";

	public static final String MODE_FIELD = "mode=";
	public static final String UNITS_FIELD = "units=";
	public static final String API_FIELD = "appid=";
	public static final String CITY_NAME_FIELD = "q=";

	public static final String WEATHER_REQUEST = "weather";
	public static final String FORECAST_DAILY_REQUEST = "forecast/daily";

	public static WeatherResponse getCurrentWeatherByCity(String city, String country) throws Exception {
		return HttpConnector.getRequestSync(getBaseUrl(WEATHER_REQUEST) + CITY_NAME_FIELD + city + "," + country,
				WeatherResponse.class);
	}

	public static ForecastResponse getForecastByCity(String city, String country) throws Exception {
		return HttpConnector.getRequestSync(getBaseUrl(FORECAST_DAILY_REQUEST) + CITY_NAME_FIELD + city + "," + country
				+ "&" + MODE_FIELD + JSON_MODE, ForecastResponse.class);
	}

	// public static void getProcessInstance(CommunicationClient
	// communicationClient, String instanceId, HttpCallback<ProcessInstance>
	// callback) {
	// HttpConnector.getRequest(communicationClient.getApplicationManager().getConnectAPIBaseURL()
	// + RestMessages.GET_PROCESS_INSTANCE + instanceId,
	// communicationClient.getSessionId(),
	// ProcessInstance.class,
	// callback);
	// }
	//
	// public static void shotUpload(CommunicationClient communicationClient,
	// FileEntryDTO file, HttpCallback<String> callback) {
	// HttpConnector.postRequest(communicationClient.getApplicationManager().getConnectAPIBaseURL()
	// + RestMessages.POST_SHOT_UPLOAD,
	// communicationClient.getSessionId(),
	// file,
	// callback);
	// }

	public static String getBaseUrl(String request) {
		return URL + request + "?" + UNITS_FIELD + CELSIUS_UNIT + "&" + API_FIELD + API_KEY + "&";
	}
}
