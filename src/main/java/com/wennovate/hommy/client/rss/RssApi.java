package com.wennovate.hommy.client.rss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.xml.client.CharacterData;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;
import com.wennovate.hommy.client.network.HttpConnector;

public class RssApi {
	private static final Logger logger = LogManager.getLogger(RssApi.class);

	public static final String GAZZETTA_FEED = "http://www.gazzetta.it/rss/home.xml";

	public static final String REPUBBLICA_FEED = "http://www.repubblica.it/rss/homepage/rss2.0.xml";
	public static final String LA_STAMPA_FEED = "http://www.lastampa.it/rss.xml";
	public static final String CORRIERE_FEED = "http://xml.corriereobjects.it/rss/homepage.xml";
	public static final String ANSA_FEED = "http://www.ansa.it/sito/ansait_rss.xml";

	public static List<RssItem> getRssFeedItems(String feedUrl) throws Exception {
		String xml = HttpConnector.getRequestSync(feedUrl, new HashMap<String, String>(),
				new HashMap<String, String>());
		return getItems(xml);
	}

	private static List<RssItem> getItems(String xml) {
		logger.info(xml);
		List<RssItem> items = new ArrayList<RssItem>();

		Document feedDocument = XMLParser.parse(xml);
		Element feedElement = feedDocument.getDocumentElement();
		NodeList itemsNodeList = feedElement.getElementsByTagName("item");
		for (int i = 0; i < itemsNodeList.getLength(); i++) {
			logger.info("parse element n" + i);
			Element item = (Element) itemsNodeList.item(i);
			String title = getCharacterDataFromElement(item.getElementsByTagName("title").item(0));
			String description = getCharacterDataFromElement(item.getElementsByTagName("description").item(0));
			String imageURL = "";
			if (item.getElementsByTagName("enclosure") != null
					&& item.getElementsByTagName("enclosure").item(0) != null) {
				imageURL = item.getElementsByTagName("enclosure").item(0).getAttributes().getNamedItem("url")
						.getNodeValue();
			}

			// cleanup description
			description = description.replace(title, "");

			RssItem rssItem = new RssItem();
			rssItem.setTitle(title);
			rssItem.setDescription(description);
			rssItem.setImageURL(imageURL);
			items.add(rssItem);
		}
		return items;
	}

	public static String getCharacterDataFromElement(Node e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

}
