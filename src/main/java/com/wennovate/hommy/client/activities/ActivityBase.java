package com.wennovate.hommy.client.activities;

public abstract class ActivityBase extends AbstractActivity implements InitializableActivity {

	@Inject
	protected MessageDialog dialog;

	protected Place place;

	protected ActivityConfiguration activityConfig;
	;

	public void initialize(Place place, ActivityConfiguration activityConfiguration, Map<String, String> activityParameters){
		this.place=place;
		this.activityConfig=activityConfiguration;
		this.activityParameters = activityParameters;
	}

	@Override
	public void onStop() {

		dialog.hide();

		super.onStop();
	}

}
