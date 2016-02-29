package com.wennovate.hommy.client.mappers;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.wennovate.hommy.client.ClientFactory;
import com.wennovate.hommy.client.activities.RssActivity;
import com.wennovate.hommy.client.places.HomePlace;

public class AppActivityMapper implements ActivityMapper {
    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace)
            return new RssActivity((HomePlace) place, clientFactory);
        return null;
    }
}
