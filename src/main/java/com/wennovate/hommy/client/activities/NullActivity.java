package com.wennovate.hommy.client.activities;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.wennovate.hommy.client.ui.NullView;

public class NullActivity extends ActivityBase {
	private NullView view;

	public NullActivity() {
		view = new NullView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view);
	}

}
