package com.wennovate.hommy.client;

import com.google.gwt.place.shared.Place;
import com.google.inject.ImplementedBy;
import com.wennovate.hommy.client.places.HomePlace;

@ImplementedBy(AppPlaceFactoryImpl.class)
public interface AppPlaceFactory {

	Place getDefaultPlace();

	HomePlace.Tokenizer getHomePlaceTokenizer();
}
