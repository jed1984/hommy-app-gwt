package com.wennovate.hommy.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;

public abstract class ActivityBase extends AbstractActivity implements InitializableActivity {

	// @Inject
	// protected MessageDialog dialog;

	protected ActivityConfiguration activityConfig;

	public void initialize(ActivityConfiguration activityConfiguration) {
		this.activityConfig = activityConfiguration;
	}

	public String getProperty(String prop) {
		return activityConfig.getProperties().get(prop);
	}

	@Override
	public void onStop() {

		// dialog.hide();

		super.onStop();
	}

}
