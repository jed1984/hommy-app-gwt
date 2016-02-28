package com.wennovate.hommy.client.mappers;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.wennovate.hommy.client.places.HomePlace;

@WithTokenizers({ HomePlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}