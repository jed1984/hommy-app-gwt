package com.wennovate.hommy.client.activities;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NamedNodeMap;
import com.wennovate.hommy.client.exceptions.ConfigurationException;

public class ActivityConfiguration {

	public static class Properties {
		public static final String CITY = "city";
	}

	private String name;
	private String clazzName;
	private Map<String, String> properties;

	public ActivityConfiguration(Element activityTag) throws ConfigurationException {
		if (!activityTag.hasAttribute("name")) {
			throw new ConfigurationException("Activity must declare a valid name");
		}
		if (!activityTag.hasAttribute("class-name")) {
			throw new ConfigurationException("Activity must declare a valid class-name");
		}

		name = activityTag.getAttribute("name");
		clazzName = activityTag.getAttribute("class-name");
		properties = new HashMap<String, String>();
		NamedNodeMap attributes = activityTag.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);
			properties.put(attribute.getNodeName(), attribute.getNodeValue());		
		}
	}

	public String getName() {
		return name;
	}

	public String getClazzName() {
		return clazzName;
	}

	public Map<String, String> getProperties() {
		return properties;
	}
}
