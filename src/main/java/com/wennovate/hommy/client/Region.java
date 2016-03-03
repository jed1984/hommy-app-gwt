package com.wennovate.hommy.client;

import com.google.gwt.xml.client.Element;
import com.wennovate.hommy.client.exceptions.ConfigurationException;

public class Region {
	public enum Position {
		TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER_LEFT, CENTER, CENTER_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT;

		public String nameLowerCase() {
			return name().toLowerCase();
		}
	}

	private Position position;
	private String activityName;

	public Region(String position, String activityName) {
		this.position = Position.valueOf(position.toUpperCase());
		this.activityName = activityName;
	}

	public Region(Element regionTag)  throws ConfigurationException {
		if (!regionTag.hasAttribute("position")) {
			throw new ConfigurationException("Region must declare a valid position");
		}
		if (!regionTag.hasAttribute("activity-name")) {
			throw new ConfigurationException("Region must declare a valid activity-name");
		}

		position = Position.valueOf(regionTag.getAttribute("position").toUpperCase());
		activityName = regionTag.getAttribute("activity-name");		
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the activity name
	 */
	public String getActivityName() {
		return activityName;
	}

	/**
	 * @param activityName
	 *            the activity name to set
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

}
