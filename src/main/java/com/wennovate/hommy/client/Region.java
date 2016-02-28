/*
 * COPYRIGHT (C) 2013 by Inventia srl
 * All rights reserved.
 *
 * This software and all the included confidential information are property
 * of Inventia srl. No part of this information may be used, reproduced,
 * or stored without prior written consent of Inventia srl.
 */
package com.wennovate.hommy.client;

public enum Region {
	TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER_LEFT, CENTER, CENTER_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT;

	public String nameLowerCase() {
		return name().toLowerCase();
	}
}
