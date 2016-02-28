package com.wennovate.hommy.client.activities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.wennovate.hommy.client.ClientFactory;
import com.wennovate.hommy.client.owm.WeatherApi;
import com.wennovate.hommy.client.owm.WeatherResponse;
import com.wennovate.hommy.client.places.HomePlace;
import com.wennovate.hommy.client.ui.WeatherView;

public class WeatherActivity extends AbstractActivity implements WeatherView.Presenter {
	private static final Logger logger = LogManager.getLogger(WeatherActivity.class);

	// Used to obtain views, eventBus, placeController
	// Alternatively, could be injected via GIN
	private ClientFactory clientFactory;
	// Name that will be appended to "Hello,"
	private String name;

	public WeatherActivity(HomePlace place, ClientFactory clientFactory) {
		// this.name = place.getHelloName();
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		WeatherView weatherView = clientFactory.getWeatherView();
		weatherView.setName(name);
		weatherView.setPresenter(this);
		containerWidget.setWidget(weatherView.asWidget());

		WeatherResponse res;
		try {
			res = WeatherApi.getCurrentWeatherByCity("Milan", "Italy");
			weatherView.setName("TEMP IS: " + res.getMain().getTemp());
			logger.info(res.getMain().getTemp());
		} catch (Exception e) {
			logger.error(e);
		}
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

}
