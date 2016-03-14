package com.wennovate.hommy.client.ui;

import com.google.gwt.user.client.ui.Composite;

public class RssViewImpl extends Composite implements RssView {

	private Presenter presenter;

	public RssViewImpl() {
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
