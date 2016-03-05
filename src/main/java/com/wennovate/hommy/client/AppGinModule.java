package com.wennovate.hommy.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryHandler.DefaultHistorian;
import com.google.gwt.place.shared.PlaceHistoryHandler.Historian;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.wennovate.hommy.client.mappers.AppPlaceHistoryMapper;
import com.wennovate.hommy.client.mappers.RegionActivityMapper.RegionActivityMapperFactory;
import com.wennovate.hommy.client.places.HomePlace;

public class AppGinModule extends AbstractGinModule {
	public static final Place DEFAULT_PLACE = new HomePlace("home");
	
	@Override
	protected void configure() {
		
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class);

		// set default page
		bind(Historian.class).to(DefaultHistorian.class);

		
		//bind(ToolActivity.class).in(Singleton.class);
		//bind(NullActivity.class).in(Singleton.class);
		
		install(new GinFactoryModuleBuilder().build(RegionActivityMapperFactory.class));
	}

	private Place getDefaultPlace() {
		return DEFAULT_PLACE;
	}

	@Provides
	@Singleton
	PlaceController providePlaceController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}

//	@Provides
//	@Singleton
//	EventBus provideEventBus() {
//		return provideEventBus();
//	}

	@Provides
	@Singleton
	PlaceHistoryHandler providePlaceHistoryHandler(AppPlaceFactory appPlaceFactory, AppPlaceHistoryMapper mapper, Historian historian, PlaceController controller, EventBus eventBus) {
		mapper.setFactory(appPlaceFactory);
		PlaceHistoryHandler historyMapper = new PlaceHistoryHandler(mapper, historian);
		historyMapper.register(controller, eventBus, getDefaultPlace());
		return historyMapper;
	}

	@Provides
	Scheduler provideScheduler() {
		return Scheduler.get();
	}
}
