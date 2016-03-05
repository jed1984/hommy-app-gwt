package com.wennovate.hommy.client.activities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.wennovate.hommy.client.owm.ForecastResponse;
import com.wennovate.hommy.client.owm.WeatherApi;
import com.wennovate.hommy.client.owm.WeatherResponse;
import com.wennovate.hommy.client.ui.WeatherView;

public class WeatherActivity extends ActivityBase implements WeatherView.Presenter {
	private static final Logger logger = LogManager.getLogger(WeatherActivity.class);

	private WeatherView view;

	@Inject
	public WeatherActivity(WeatherView view) {
		this.view = view;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		view.setTemperature("TEST");
		view.setPresenter(this);
		containerWidget.setWidget(view.asWidget());

		try {
			WeatherResponse weatherRes = WeatherApi.getCurrentWeatherByCity("Milan", "Italy");

			ForecastResponse forecastRes = WeatherApi.getForecastByCity("Milan", "Italy");
			view.setTemperature("TEMP IS: " + weatherRes.getMain().getTemp() + " - TOMORROW MAX: "
					+ forecastRes.getList().get(0).getTemp().getMax() + " - TOMORROW MIN: "
					+ forecastRes.getList().get(0).getTemp().getMin());
			view.setIcon(weatherRes.getWeather().get(0).getIcon());
			logger.info(weatherRes.getMain().getTemp());
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {

	}

}
