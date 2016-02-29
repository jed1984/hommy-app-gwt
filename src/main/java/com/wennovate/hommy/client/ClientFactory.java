package com.wennovate.hommy.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.wennovate.hommy.client.ui.ClockView;
import com.wennovate.hommy.client.ui.RssView;
import com.wennovate.hommy.client.ui.WeatherView;

public interface ClientFactory {
	
	EventBus getEventBus();
	PlaceController getPlaceController();

	ClockView getClockView();
	WeatherView getWeatherView();
	RssView getRssView();
}