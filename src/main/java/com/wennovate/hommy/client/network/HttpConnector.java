/*
 * COPYRIGHT (C) 2013 by Inventia srl
 * All rights reserved.
 * 
 * This software and all the included confidential information are property
 * of Inventia srl. No part of this information may be used, reproduced,
 * or stored without prior written consent of Inventia srl.
 */
package com.wennovate.hommy.client.network;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.wennovate.hommy.client.utils.JsonParser;

public class HttpConnector {
	private static final Logger logger = LogManager.getLogger(HttpConnector.class);

	public interface HttpCallback<T> {
		public void onSuccess(T response);

		public void onError(Throwable error);
	}

	// public static <T> void postRequest(String url, String sessionId, T obj,
	// final HttpCallback<String> callback) {
	// String body = JsonParser.toJson(obj);
	// postRequest(url, sessionId, body, new RequestCallback() {
	//
	// @Override
	// public void onResponseReceived(Request request, Response response) {
	// try {
	// if (response.getStatusCode() != Response.SC_OK) {
	// callback.onError(new Exception("Server error. Return code " +
	// response.getStatusCode() + " - " + response.getStatusText()));
	// }
	// else {
	// String id = JsonParser.fromJson(response.getText(), String.class);
	// callback.onSuccess(id);
	// }
	// }
	// catch (Exception e) {
	// callback.onError(e);
	// }
	// }
	//
	// @Override
	// public void onError(Request request, Throwable exception) {
	// callback.onError(exception);
	//
	// }
	// });
	// }
	//
	// private static void postRequest(String url, String sessionId, String
	// requestData, RequestCallback callback) {
	// RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
	// builder.setHeader("Content-type", "application/json");
	// builder.setHeader(HEADER_SESSION_ID, sessionId);
	//
	// try {
	// builder.sendRequest(requestData, callback);
	// }
	// catch (RequestException e) {
	// callback.onError(null, e);
	// logger.error("Post request " + url + " Error", e);
	// }
	// }

	public static <T extends JavaScriptObject> void getRequest(String url, String sessionId, final Class<T> classOfT,
			final HttpCallback<T> callback) {
		Map<String, String> headers = new HashMap<String, String>();
		// headers.put(HEADER_SESSION_ID, sessionId);

		getRequest(url, headers, null, classOfT, callback);
	}

	public static <T extends JavaScriptObject> void getRequest(String url, final Class<T> classOfT,
			final HttpCallback<T> callback) {
		getRequest(url, new HashMap<String, String>(), new HashMap<String, String>(), classOfT, callback);
	}

	public static <T extends JavaScriptObject> void getRequest(String url, Map<String, String> headers,
			Map<String, String> parameters, final Class<T> classOfT, final HttpCallback<T> callback) {
		getRequest(url, headers, parameters, new RequestCallback() {

			@Override
			public void onResponseReceived(Request request, Response response) {
				try {
					logger.info("Get Response: " + response.getText());
					if (response.getStatusCode() == Response.SC_OK || response.getStatusCode() == 0) {
						T obj = JsonParser.fromJson(response.getText(), classOfT);
						callback.onSuccess(obj);
					} else {
						callback.onError(new Exception("Server error. Return code " + response.getStatusCode() + " - "
								+ response.getStatusText()));
					}
				} catch (Exception e) {
					callback.onError(e);
				}
			}

			@Override
			public void onError(Request request, Throwable exception) {
				callback.onError(exception);
			}
		});

	}

	private static void getRequest(String url, Map<String, String> headers, Map<String, String> parameters,
			RequestCallback callback) {

		// /// PARAMETERS /////
		if (parameters != null && !parameters.isEmpty()) {
			StringBuilder sb = new StringBuilder("?");
			for (String key : parameters.keySet()) {
				String value = URL.encodeQueryString(parameters.get(key));
				if (sb.length() > 1) {
					sb.append("&");
				}
				sb.append(key).append("=").append(value);
			}
			url += sb.toString();
		}

		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url);

		// /// HEADERS /////
		requestBuilder.setHeader("Content-type", "application/x-www-form-urlencoded");
		if (headers != null) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				requestBuilder.setHeader(entry.getKey(), entry.getValue());
			}
		}

		// /// REQUEST /////
		try {
			requestBuilder.sendRequest(null, callback);
		} catch (RequestException e) {
			callback.onError(null, e);
			logger.error("Get request " + url + " Error", e);
		}
	}

	public static <T extends JavaScriptObject> T getRequestSync(String url, final Class<T> classOfT) throws Exception {
		Map<String, String> headers = new HashMap<String, String>();
		// headers.put(HEADER_SESSION_ID, sessionId);
		return getRequestSync(url, headers, null, classOfT);
	}

	public static <T extends JavaScriptObject> T getRequestSync(String url, Map<String, String> headers,
			Map<String, String> parameters, final Class<T> classOfT) throws Exception {
		String ret = getRequestSync(url, headers, parameters);
		return JsonParser.fromJson(ret, classOfT);
	}

	public static String getRequestSync(String url, Map<String, String> headers, Map<String, String> parameters)
			throws Exception {
		if (parameters != null && !parameters.isEmpty()) {
			url += "?";
			// /// PARAMETERS /////
			StringBuilder sb = new StringBuilder();
			if (parameters != null) {
				for (String k : parameters.keySet()) {
					String vx = URL.encodeQueryString(parameters.get(k));
					if (sb.length() > 0) {
						sb.append("&");
					}
					sb.append(k).append("=").append(vx);
				}
			}
			url += sb.toString();
		}

		@SuppressWarnings("unchecked")
		JsArray<JsKeyValue> jsHeaders = (JsArray<JsKeyValue>) JsArray.createArray();
		jsHeaders.push(JsKeyValue.getInstance("Content-type", "application/x-www-form-urlencoded"));
		if (headers != null) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				jsHeaders.push(JsKeyValue.getInstance(entry.getKey(), entry.getValue()));
			}
		}
		return _getRequestSync(url, jsHeaders);

	}

	/** NATIVE FUNCTIONS @formatter:off **/

	/**
	 * Returns in callback the blobUrl of the given remote file
	 *
	 * @param url
	 *            http url
	 * @param mimetype
	 *            "application/pdf", "image/jpeg", "image/png"
	 * @param handler
	 */
	public static native void fileGetRequest(String url, String mimetype, Callback<String, String> handler) /*-{
		// download pdf via ajax and blob
		var xhr = new XMLHttpRequest();
		xhr.open('GET', url, true);
		xhr.responseType = 'arraybuffer';

		xhr.onload = function(e) {
			// convert bob to url and pass to pdfjs
			var blob = new Blob([ xhr.response ], {
				type : mimetype
			});
			var blobUrl = URL.createObjectURL(blob);

			handler.@com.google.gwt.core.client.Callback::onSuccess(*)(blobUrl);
		};
		xhr.onerror = function(e) {
			console.log("PDFJS: ERROR during pdf download: "
					+ JSON.stringify(e));
			handler.@com.google.gwt.core.client.Callback::onFailure(*)(e);
		}
		xhr.send();
	}-*/;

	private static class JsKeyValue extends JavaScriptObject {
		protected JsKeyValue() {

		}

		public static native JsKeyValue getInstance(String key, String value)/*-{
			var obj = new $wnd.Object();
			obj.key = "" + key;
			obj.value = "" + value;
			return obj;
		}-*/;

	}

	private native static String _getRequestSync(String url, JsArray<JsKeyValue> headers) throws Exception /*-{
		var xhr = new $wnd.XMLHttpRequest();
		xhr.open("GET", url, false);
		var index;

		for (index = 0; index < headers.length; index++) {
			var head = headers[index];
			xhr.setRequestHeader(head.key, head.value);
		}

		xhr.send(null);
		if (xhr.status == 200 || xhr.status == 0) {
			return xhr.responseText;
		} else {
			throw "Server error. Return code " + xhr.status;
		}
	}-*/;

}
