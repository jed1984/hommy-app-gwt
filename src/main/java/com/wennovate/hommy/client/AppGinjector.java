package com.wennovate.hommy.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.wennovate.hommy.client.mappers.RegionActivityMapper.RegionActivityMapperFactory;

@GinModules({AppGinModule.class})
public interface AppGinjector extends Ginjector {
	//public static final AppGinjector INSTANCE = GWT.create(AppGinjector.class);

	EventBus eventBus();
	PlaceHistoryHandler placeHistoryHandler();
	RegionActivityMapperFactory regionActivityMapperFactory();

}
