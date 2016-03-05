package com.wennovate.hommy.client.mappers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.wennovate.hommy.client.Region.Position;
import com.wennovate.hommy.client.activities.ActivityConfiguration;
import com.wennovate.hommy.client.activities.InitializableActivity;
import com.wennovate.hommy.client.activities.NullActivity;
import com.wennovate.hommy.client.utils.ApplicationConfiguration;

public class RegionActivityMapper implements ActivityMapper {
	private static final Logger logger = LogManager.getLogger(RegionActivityMapper.class);

	private final Position regionPosition;

	private ActivityMapperFactory activityFactory;

	public interface RegionActivityMapperFactory {
		RegionActivityMapper create(@Assisted("regionPosition") Position regionPosition);
	}

	private String currentActivityName;
	private InitializableActivity currentActivity;

	@Inject
	private NullActivity nullActivity;

	@Inject
	RegionActivityMapper(ActivityMapperFactory activityFactory, @Assisted("regionPosition") Position regionPosition) {
		this.activityFactory = activityFactory;
		this.regionPosition = regionPosition;
		this.currentActivity = null;
		this.currentActivityName = null;
	}

	@Override
	public Activity getActivity(Place place) {
		ApplicationConfiguration applicationConfig = ApplicationConfiguration.get();

		ActivityConfiguration activityConfig = applicationConfig.getActivityConfiguration(regionPosition);

		if (activityConfig == null || activityConfig.getName() == null) {
			logger.warn("Cannot retrieve activity configuration for region position " + regionPosition
					+ " returning NullActivity ...");
			currentActivity = nullActivity;
			currentActivityName = null;
		} else if (currentActivity == null || currentActivityName == null
				|| !currentActivityName.equals(activityConfig.getName())) {
			currentActivity = getActivity(activityConfig.getClazzName());
			currentActivityName = activityConfig.getName();
			logger.info("Replacing activity for place " + place + " and region " + regionPosition + " to "
					+ currentActivityName + ".");
		} else {
			logger.info("Keeping cached activity " + currentActivityName + " for place " + place + " and region "
					+ regionPosition + ".");
		}

		if (currentActivity != null) {
			currentActivity.initialize(activityConfig);
		}

		return currentActivity;
	}

	public <T extends InitializableActivity> T getActivity(Class<T> clazz, Place place,
			ActivityConfiguration activityConfiguration) {
		T ret = activityFactory.getActivity(clazz);
		if (ret != null) {
			ret.initialize(activityConfiguration);
		}
		return ret;
	}

	private InitializableActivity getActivity(String simpleClazzName) {
		return activityFactory.getActivity(simpleClazzName);
	}

}
