package com.wennovate.hommy.client;

import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.wennovate.hommy.client.Region.Position;
import com.wennovate.hommy.client.mappers.RegionActivityMapper;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Hommy implements EntryPoint {
	private static final Logger logger = LogManager.getLogger(Hommy.class);

	private final AppGinjector injector = GWT.create(AppGinjector.class);

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	//private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	//private final Messages messages = GWT.create(Messages.class);

	private HashMap<Position, Widget> regions = new HashMap<>();
	private HashMap<Position, RegionActivityMapper> regionsActivityMapper = new HashMap<>();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		logger.info("************ onModuleLoad ************");
		FlowPanel container = new FlowPanel();
		container.ensureDebugId("cwFlowPanel");

		// Add some content to the panel
		for (Position p : Position.values()) {
			container.add(createRegion(p));
		}

		RootPanel.get().add(container);

		// Goes to the place represented on URL else default place
		injector.placeHistoryHandler().handleCurrentHistory();
	}

	private Widget createRegion(Position position) {
		return createRegion(position, new SimplePanel());
	}

	private Widget createRegion(Position position, SimplePanel regionPanel) {
		// Region configuration
		String positionName = position.name();
		regionPanel.getElement().setId(positionName);
		regionPanel.getElement().setClassName(positionName);
		regionPanel.getElement().setPropertyObject("functions", new Object());

		RegionActivityMapper regionActivityMapper = injector.regionActivityMapperFactory().create(position);
		ActivityManager regionActivityManager = new ActivityManager(regionActivityMapper, injector.eventBus());
		regionActivityManager.setDisplay(regionPanel);
		regions.put(position, regionPanel);
		regionsActivityMapper.put(position, regionActivityMapper);

		return regionPanel;
	}
}
