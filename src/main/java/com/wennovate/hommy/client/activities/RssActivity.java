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
import com.wennovate.hommy.client.activities.ActivityConfiguration.Properties;
import com.wennovate.hommy.client.rss.RssApi;
import com.wennovate.hommy.client.rss.RssItem;
import com.wennovate.hommy.client.ui.RssView;

public class RssActivity extends ActivityBase implements RssView.Presenter {
	private static final Logger logger = LogManager.getLogger(RssActivity.class);

	private RssView view;
	private String feedName;
	private int feedNum = 50;

	@Inject
	public RssActivity(RssView view) {
		this.view = view;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		// TODO add feeds to application-config file, parse them and use feed
		// reading urls from a map
		this.feedName = getProperty(Properties.FEED_NAME);

		if (getProperty(Properties.FEED_NUM) != null) {
			this.feedNum = Integer.parseInt(getProperty(Properties.FEED_NUM));
		}

		try {
			List<RssItem> items = RssApi.getRssFeedItems(RssApi.GAZZETTA_FEED);

			VerticalPanel rssVPanel = new VerticalPanel();
			rssVPanel.getElement().setId("rss");
			// TODO set title runtime
			HTML header = new HTML("FEED GAZZETTA");
			header.setStyleName("header");
			rssVPanel.add(header);

			int feedCount = 0;
			// Add items content to the panel
			for (RssItem rssItem : items) {
				DockPanel itemPanel = new DockPanel();
				itemPanel.setStyleName("item");

				HTML titlePanel = new HTML(rssItem.getTitle());
				titlePanel.setStyleName("title");
				itemPanel.add(titlePanel, DockPanel.NORTH);

				HTML descriptionPanel = new HTML(rssItem.getDescription());
				descriptionPanel.setStyleName("description");
				itemPanel.add(descriptionPanel, DockPanel.CENTER);

				if (!rssItem.getImageURL().isEmpty()) {
					Image imagePanel = new Image(rssItem.getImageURL(), 0, 0, 120, 60);
					imagePanel.setStyleName("image");
					itemPanel.add(imagePanel, DockPanel.WEST);
				}

				rssVPanel.add(itemPanel);
				if (++feedCount >= feedNum)
					break;
			}

			containerWidget.setWidget(rssVPanel);
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
