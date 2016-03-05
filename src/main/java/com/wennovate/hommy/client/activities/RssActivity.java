package com.wennovate.hommy.client.activities;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.inject.Inject;
import com.wennovate.hommy.client.rss.RssApi;
import com.wennovate.hommy.client.rss.RssItem;
import com.wennovate.hommy.client.ui.RssView;

public class RssActivity extends ActivityBase implements RssView.Presenter {
	private static final Logger logger = LogManager.getLogger(RssActivity.class);

	private RssView view;

	@Inject
	public RssActivity(RssView view) {
		this.view = view;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		// RssView helloView = clientFactory.getRssView();
		// helloView.setName(name);
		// helloView.setPresenter(this);
		// containerWidget.setWidget(helloView.asWidget());
		// helloView.setName(items.toString());

		try {
			List<RssItem> items = RssApi.getRssFeedItems(RssApi.GAZZETTA_FEED);

			VerticalPanel itemsVPanel = new VerticalPanel();
			itemsVPanel.setSpacing(5);

			// Add some content to the panel
			for (RssItem rssItem : items) {
				DockPanel panel = new DockPanel();
				panel.add(new HTML(rssItem.getTitle()), DockPanel.NORTH);
				panel.add(new HTML(rssItem.getDescription()), DockPanel.CENTER);
				if (!rssItem.getImageURL().isEmpty())
					panel.add(new Image(rssItem.getImageURL(), 0, 0, 40, 40), DockPanel.WEST);
				itemsVPanel.add(panel);
			}

			containerWidget.setWidget(itemsVPanel);

			logger.info(items);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		
	}
}
