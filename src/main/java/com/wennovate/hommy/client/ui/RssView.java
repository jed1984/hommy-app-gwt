package com.wennovate.hommy.client.ui;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

@ImplementedBy(RssViewImpl.class)
public interface RssView extends IsWidget {
	void setPresenter(Presenter presenter);

	public interface Presenter {
	}
}
