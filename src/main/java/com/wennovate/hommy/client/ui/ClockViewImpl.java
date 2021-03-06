package com.wennovate.hommy.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ClockViewImpl extends Composite implements ClockView {
	private static ClockViewImplUiBinder uiBinder = GWT.create(ClockViewImplUiBinder.class);

	interface ClockViewImplUiBinder extends UiBinder<Widget, ClockViewImpl> {
	}

//	@UiField
//	SpanElement nameSpan;
//	@UiField
//	Anchor goodbyeLink;

	private Presenter presenter;
	private String name;

	public ClockViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setName(String name) {
		this.name = name;
//		nameSpan.setInnerText(name);
	}
//
//	@UiHandler("goodbyeLink")
//	void onClickGoodbye(ClickEvent e) {
//		// presenter.goTo(new GoodbyePlace(name));
//	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
