package com.wennovate.hommy.client.owm;

import com.wennovate.hommy.client.network.HttpConnector;

public class WeatherApi {
	public static final String API_KEY = "0c84a7bca36ec85f31291354994eb62f";

	public static final String URL = "http://api.openweathermap.org/data/2.5/";
	public static final String API_FIELD = "appid=";
	public static final String CITY_NAME_FIELD = "q=";

	public enum Request {
		WEATHER;

		public String toString() {
			return name().toLowerCase();
		};
	}

	public static WeatherResponse getCurrentWeatherByCity(String city, String country) throws Exception {
		return HttpConnector.getRequestSync(getBaseUrl(Request.WEATHER) + CITY_NAME_FIELD + city + "," + country,
				WeatherResponse.class);
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

	public static String getBaseUrl(Request request) {
		return URL + request + "?" + API_FIELD + API_KEY + "&";
	}
}
