package com.wennovate.hommy.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;
import com.wennovate.hommy.client.owm.ForecastResponse;
import com.wennovate.hommy.client.owm.WeatherResponse;

@ImplementedBy(WeatherViewImpl.class)
public interface WeatherView extends IsWidget {
    void updateCurrentWeather(WeatherResponse weather);
    void updateForecast(ForecastResponse forecast);
    void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }
}
