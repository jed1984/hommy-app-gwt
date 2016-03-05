/*
 * COPYRIGHT (C) 2013 by Inventia srl
 * All rights reserved.
 * 
 * This software and all the included confidential information are property
 * of Inventia srl. No part of this information may be used, reproduced,
 * or stored without prior written consent of Inventia srl.
 */
package com.wennovate.hommy.client.mappers;

import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.wennovate.hommy.client.AppGinModule;
import com.wennovate.hommy.client.places.HomePlace;

@Singleton
public class AppPlaceFactoryImpl implements AppPlaceFactory {

	@Inject
	HomePlace.Tokenizer homePlaceTokenizer;

	public final Place getDefaultPlace() {
		return AppGinModule.DEFAULT_PLACE;
	}

	@Override
	public final HomePlace.Tokenizer getHomePlaceTokenizer() {
		return homePlaceTokenizer;
	}

}
