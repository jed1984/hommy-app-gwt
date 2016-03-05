package com.wennovate.hommy.client.factories;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.activity.shared.Activity;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.wennovate.hommy.client.activities.ClockActivity;
import com.wennovate.hommy.client.activities.InitializableActivity;
import com.wennovate.hommy.client.activities.NullActivity;
import com.wennovate.hommy.client.activities.RssActivity;
import com.wennovate.hommy.client.activities.WeatherActivity;

public class ActivityFactory {
	private static final Logger logger = LogManager.getLogger(ActivityFactory.class);

	protected Map<String, Provider<? extends InitializableActivity>> registeredActivities = new HashMap<>();

	@Inject
	public ActivityFactory(Provider<RssActivity> rssActivity, 
			Provider<WeatherActivity> weatherActivity,
			Provider<ClockActivity> clockActivity, 
			Provider<NullActivity> nullActivity) {
		registeredActivities.put(RssActivity.class.getSimpleName(), rssActivity);
		registeredActivities.put(WeatherActivity.class.getSimpleName(), weatherActivity);
		registeredActivities.put(ClockActivity.class.getSimpleName(), clockActivity);
		registeredActivities.put(NullActivity.class.getSimpleName(), nullActivity);
	}

	public InitializableActivity getActivity(String activitySimpleName) {

		Provider<? extends InitializableActivity> provider = registeredActivities.get(activitySimpleName);

		if (provider != null) {
			return provider.get();
		}

		logger.error("Error: Activity " + activitySimpleName + " not found");

		return null;
	}

	public Activity getNullActivity() {
		return registeredActivities.get(NullActivity.class.getSimpleName()).get();
	}

	@SuppressWarnings("unchecked")
	public <T extends InitializableActivity> T getActivity(Class<T> clazz) {

		return (T) getActivity(clazz.getSimpleName());
	}
}
