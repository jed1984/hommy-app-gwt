package com.wennovate.hommy.client.utils;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;

public class JsonParser {

	public static <T extends JavaScriptObject> T fromJson(String json, Class<T> callsOfT) {
		return JsonUtils.safeEval(json);
	}
}
