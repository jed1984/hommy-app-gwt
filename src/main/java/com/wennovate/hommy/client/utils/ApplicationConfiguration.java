package com.wennovate.hommy.client.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gwt.dom.client.MetaElement;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NamedNodeMap;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.XMLParser;
import com.wennovate.hommy.client.Region;
import com.wennovate.hommy.client.Region.Position;
import com.wennovate.hommy.client.activities.ActivityConfiguration;
import com.wennovate.hommy.client.exceptions.ConfigurationException;

public class ApplicationConfiguration {
	private static final Logger logger = LogManager.getLogger(ApplicationConfiguration.class);

	private static final String NAME = "application-configuration";

	private Map<String, String> metadata;

	private Map<String, ActivityConfiguration> activities;

	private Map<String, Region> regions;

	public ApplicationConfiguration() throws ConfigurationException {
		logger.info("Application config loading...");

		String text = File.loadTextFileSync(getApplicationConfig());
		Document applicationDocument = XMLParser.parse(text);
		parseConfigurations(applicationDocument);
	}

	private void parseConfigurations(Document applicationDocument) throws ConfigurationException {
		metadata = new HashMap<>();
		activities = new HashMap<>();
		regions = new HashMap<>();

		Element applicationRoot = applicationDocument.getDocumentElement();

		NamedNodeMap metadataNodeList = applicationRoot.getAttributes();
		for (int i = 0; i < metadataNodeList.getLength(); i++) {
			Node metadataElement = metadataNodeList.item(i);
			metadata.put(metadataElement.getNodeName(), metadataElement.getNodeValue());
		}

		// Activities
		Element activitiesTag = XMLUtils.getChildTagByName(applicationRoot, "activities");
		if (activitiesTag != null) {
			List<Element> activityTagList = XMLUtils.getChildrenTagsByName(activitiesTag, "activity");
			for (Element activityTag : activityTagList) {
				ActivityConfiguration activityConf = new ActivityConfiguration(activityTag);
				activities.put(activityConf.getName(), activityConf);
			}
		}

		Element regionsTag = XMLUtils.getChildTagByName(applicationRoot, "regions");
		if (regionsTag == null) {
			throw new ConfigurationException("regions tag not found");
		}
		List<Element> regionTagList = XMLUtils.getChildrenTagsByName(regionsTag, "region");
		for (Element regionTag : regionTagList) {
			Region region = new Region(regionTag);
			regions.put(region.getPosition().name(), region);
		}
	}

	private String getApplicationConfig() throws ConfigurationException {
		NodeList<com.google.gwt.dom.client.Element> list = com.google.gwt.dom.client.Document.get()
				.getElementsByTagName(MetaElement.TAG);
		int found = 0;
		MetaElement appConfig = null;
		for (int i = 0; i < list.getLength(); i++) {
			if (MetaElement.as(list.getItem(i)).getName().equals(NAME)) {
				appConfig = MetaElement.as(list.getItem(i));
				found++;
			}
		}
		if (found != 1) {
			throw new ConfigurationException("Application Configuration not found!");
		}
		return appConfig.getContent();
	}

	// ////////////////////////////////////////////
	// //////////////// PUBLIC ////////////////////
	// ////////////////////////////////////////////

	public ActivityConfiguration getActivityConfiguration(Position regionPosition) {
		if (regions != null && regions.get(regionPosition.name()) != null) {
			String activityName = regions.get(regionPosition.name()).getActivityName();
			return activities.get(activityName);
		}
		return null;
	}

	public String getMetadataValue(String key) {
		return getMetadataValue(key, null);
	}

	public String getMetadataValue(String key, String defaultValue) {
		String val = metadata.get(key);
		if (val == null) {
			val = defaultValue;
		}
		return val;
	}
}