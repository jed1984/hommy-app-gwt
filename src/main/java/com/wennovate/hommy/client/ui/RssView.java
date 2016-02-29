package com.wennovate.hommy.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface RssView extends IsWidget {
    void setName(String helloName);
    void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }
}
