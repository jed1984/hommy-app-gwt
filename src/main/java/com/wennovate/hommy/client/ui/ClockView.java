package com.wennovate.hommy.client.ui;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

@ImplementedBy(ClockViewImpl.class)
public interface ClockView extends IsWidget {
	void setName(String helloName);

	void setPresenter(Presenter presenter);

	public interface Presenter {
	}
}
