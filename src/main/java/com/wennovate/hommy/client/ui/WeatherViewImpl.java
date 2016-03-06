package com.wennovate.hommy.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.wennovate.hommy.client.owm.ForecastResponse;
import com.wennovate.hommy.client.owm.WeatherResponse;

public class WeatherViewImpl extends Composite implements WeatherView {
	private static WeatherViewImplUiBinder uiBinder = GWT.create(WeatherViewImplUiBinder.class);

	interface WeatherViewImplUiBinder extends UiBinder<Widget, WeatherViewImpl> {
	}

	@UiField
	ParagraphElement city;
	@UiField
	ParagraphElement currentTemperature;
	@UiField
	ParagraphElement highestTemperature;
	@UiField
	ParagraphElement lowestTemperature;
	@UiField
	ParagraphElement weatherDescription;
	@UiField
	Image weatherIcon;

	@UiField
	ParagraphElement wind;
	@UiField
	ParagraphElement rain;
	@UiField
	ParagraphElement clouds;

	private Presenter presenter;

	public WeatherViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	// @Override
	// public void setCurrentTemperature(String temperature) {
	// currentTemperature.setInnerText(temperature);
	// }
	//
	// @Override
	// public void setIcon(String iconId) {
	// weatherIcon.setUrl("http://openweathermap.org/img/w/" + iconId + ".png");
	// }

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void updateCurrentWeather(WeatherResponse weatherResponse) {
		city.setInnerText(weatherResponse.getName());
		highestTemperature.setInnerText(weatherResponse.getMain().getTempMax() + "°");
		lowestTemperature.setInnerText(weatherResponse.getMain().getTempMin() + "°");
		currentTemperature.setInnerText(weatherResponse.getMain().getTemp() + "°");
		wind.setInnerHTML(weatherResponse.getWind().getSpeed() + "kmh");
		rain.setInnerHTML(weatherResponse.getRain().get3H() + " in 3h");
		clouds.setInnerHTML(weatherResponse.getClouds().getAll()+ "");
		weatherDescription.setInnerText(weatherResponse.getWeather().get(0).getDescription());
		weatherIcon.setUrl("http://openweathermap.org/img/w/" + weatherResponse.getWeather().get(0).getIcon() + ".png");
	}

	@Override
	public void updateForecast(ForecastResponse weather) {
		// TODO Auto-generated method stub

	}
}
