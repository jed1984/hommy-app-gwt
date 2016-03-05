package com.wennovate.hommy.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

@ImplementedBy(WeatherViewImpl.class)
public interface WeatherView extends IsWidget {
	public void setIcon(String iconId);
    void setTemperature(String temperature);
    void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }
}
