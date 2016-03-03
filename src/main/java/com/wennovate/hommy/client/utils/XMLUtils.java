package com.wennovate.hommy.client.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.xml.client.Attr;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NamedNodeMap;
import com.google.gwt.xml.client.Node;

public class XMLUtils {

	public static List<Element> getChildrenTagsByName(Element element, String name) {
		List<Element> children = new ArrayList<>();
		if (element == null || element.getChildNodes() == null) {
			return children;
		}
		for (int i = 0; i < element.getChildNodes().getLength(); i++) {
			Node child = element.getChildNodes().item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE && name.equals(((Element) child).getTagName())) {
				children.add((Element) child);
			}
		}
		return children;

	}

	public static List<Element> getChildrenTags(Element element) {
		List<Element> children = new ArrayList<>();
		if (element == null || element.getChildNodes() == null) {
			return children;
		}
		for (int i = 0; i < element.getChildNodes().getLength(); i++) {
			Node child = element.getChildNodes().item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				children.add((Element) child);
			}
		}
		return children;
	}

	public static Element getChildTagByName(Element element, String name) {
		if (element == null || element.getChildNodes() == null) {
			return null;
		}
		for (int i = 0; i < element.getChildNodes().getLength(); i++) {
			Node child = element.getChildNodes().item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE && name.equals(((Element) child).getTagName())) {
				return ((Element) child);
			}
		}
		return null;
	}

	public static Map<String, String> namedNodeMapToStringMap(NamedNodeMap attributeMap) {
		Map<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < attributeMap.getLength(); ++i) {
			Attr n = (Attr) attributeMap.item(i);
			map.put(n.getName(), n.getValue());
		}
		return map;
	}
}
