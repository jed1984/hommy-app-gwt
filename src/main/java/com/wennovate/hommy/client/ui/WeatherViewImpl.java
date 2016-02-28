package com.wennovate.hommy.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class WeatherViewImpl extends Composite implements WeatherView {
	private static WeatherViewImplUiBinder uiBinder = GWT.create(WeatherViewImplUiBinder.class);

	interface WeatherViewImplUiBinder extends UiBinder<Widget, WeatherViewImpl> {
	}

	@UiField
	SpanElement nameSpan;
	@UiField
	Anchor goodbyeLink;
	@UiField
	Image imageWidget;

	private Presenter presenter;
	private String temperature;
	private String iconId;

	public WeatherViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setTemperature(String temperature) {
		this.temperature = temperature;
		nameSpan.setInnerText(temperature);
	}

	@Override
	public void setIcon(String iconId) {
		this.iconId = iconId;
		imageWidget.setUrl("http://openweathermap.org/img/w/" + iconId + ".png");
	}

	@UiHandler("goodbyeLink")
	void onClickGoodbye(ClickEvent e) {
		// presenter.goTo(new GoodbyePlace(name));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
