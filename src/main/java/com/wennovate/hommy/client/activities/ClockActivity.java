package com.wennovate.hommy.client.activities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.wennovate.hommy.client.ui.ClockView;

public class ClockActivity extends ActivityBase implements ClockView.Presenter {
	private static final Logger logger = LogManager.getLogger(ClockActivity.class);

	private ClockView view;

	@Inject
	public ClockActivity(ClockView view) {
		this.view = view;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		containerWidget.setWidget(view.asWidget());
		run();
	}

	public native void run()/*-{
		$wnd.clockRun();
	}-*/;

	// public native void test()/*-{
	// var clock = $doc.getElementById('test');
	//
	// // But there is a little problem
	// // we need to pad 0-9 with an extra
	// // 0 on the left for hours, seconds, minutes
	//
	// var pad = function(x) {
	// return x < 10 ? '0' + x : x;
	// };
	//
	// var ticktock = function() {
	// var d = new Date();
	//
	// var h = pad(d.getHours());
	// var m = pad(d.getMinutes());
	// var s = pad(d.getSeconds());
	//
	// var current_time = [ h, m, s ].join(':');
	//
	// clock.innerHTML = current_time;
	//
	// };
	//
	// ticktock();
	//
	// // Calling ticktock() every 1 second
	// setInterval(ticktock, 1000);
	// }-*/;

}
