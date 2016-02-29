package com.wennovate.hommy.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.wennovate.hommy.client.ui.ClockView;
import com.wennovate.hommy.client.ui.ClockViewImpl;
import com.wennovate.hommy.client.ui.RssView;
import com.wennovate.hommy.client.ui.RssViewImpl;
import com.wennovate.hommy.client.ui.WeatherView;
import com.wennovate.hommy.client.ui.WeatherViewImpl;

public class ClientFactoryImpl implements ClientFactory {
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);

	private final ClockView clockView = new ClockViewImpl();
	private final WeatherView weatherView = new WeatherViewImpl();
	private final RssView rssView = new RssViewImpl();

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public ClockView getClockView() {
		return clockView;
	}

	@Override
	public WeatherView getWeatherView() {
		return weatherView;
	}

	@Override
	public RssView getRssView() {
		return rssView;
	}
}
