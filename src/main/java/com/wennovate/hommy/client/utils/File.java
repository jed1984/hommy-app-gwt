package com.wennovate.hommy.client.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class File {
	private static final Logger logger = LogManager.getLogger(File.class);

	public interface FileCallbacks {
		void onLoadComplete(String text);

		void onError(String error);
	}

	public native static void loadTextFile(String fileName, FileCallbacks callbacks) /*-{
		var xhr = new $wnd.XMLHttpRequest();
		xhr.open("GET", fileName, true);
		xhr.onload = function(e) {
			if (xhr.readyState === 4) {
				if (xhr.status === 200 || xhr.status === 0) {
					callbacks.@com.wennovate.hommy.client.utils.File.FileCallbacks::onLoadComplete(Ljava/lang/String;)(xhr.responseText);
				} else {
					console.error("File " + fileName + " loading error status:"
							+ xhr.status + " statusText:" + xhr.statusText);
					callbacks.@com.wennovate.hommy.client.utils.File.FileCallbacks::onError(Ljava/lang/String;)(xhr.statusText);
				}
			}
		};
		xhr.onerror = function(e) {
			console.error("File onError " + fileName + " loading error status:"
					+ xhr.status + " statusText:" + xhr.statusText);
			callbacks.@com.wennovate.hommy.client.utils.File.FileCallbacks::onError(Ljava/lang/String;)(xhr.statusText);
		};
		xhr.send(null);
	}-*/;


	public native static String loadTextFileSync(String fileName) /*-{
		var xhr = new $wnd.XMLHttpRequest();
		xhr.open("GET", fileName, false);
		xhr.send(null);
		if (xhr.status == 200 || xhr.status == 0) {
			return xhr.responseText;
		} else {
			return null;
		}
	}-*/;

}
