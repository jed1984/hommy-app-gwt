package com.wennovate.hommy.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.wennovate.hommy.client.ClientFactory;
import com.wennovate.hommy.client.places.HomePlace;
import com.wennovate.hommy.client.ui.ClockView;

public class ClockActivity extends AbstractActivity implements ClockView.Presenter {
	// Used to obtain views, eventBus, placeController
	// Alternatively, could be injected via GIN
	private ClientFactory clientFactory;
	// Name that will be appended to "Hello,"
	private String name;

	public ClockActivity(HomePlace place, ClientFactory clientFactory) {
		// this.name = place.getHelloName();
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		ClockView helloView = clientFactory.getClockView();
		helloView.setName(name);
		helloView.setPresenter(this);
		containerWidget.setWidget(helloView.asWidget());
		
		test();
	}

	/**
	 * Ask user before stopping this activity
	 */
	@Override
	public String mayStop() {
		return "Please hold on. This activity is stopping.";
	}

	@Override
	public void onStop() {
		super.onStop();
		// TODO Kill intervall
	}
	
	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	public native void test()/*-{
		var clock = $doc.getElementById('test');

		// But there is a little problem
		// we need to pad 0-9 with an extra
		// 0 on the left for hours, seconds, minutes

		var pad = function(x) {
			return x < 10 ? '0' + x : x;
		};

		var ticktock = function() {
			var d = new Date();

			var h = pad(d.getHours());
			var m = pad(d.getMinutes());
			var s = pad(d.getSeconds());

			var current_time = [ h, m, s ].join(':');

			clock.innerHTML = current_time;

		};

		ticktock();

		// Calling ticktock() every 1 second
		setInterval(ticktock, 1000);
	}-*/;

}
