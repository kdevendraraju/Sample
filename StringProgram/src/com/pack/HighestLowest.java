package com.pack;

import java.util.TreeMap;

public class HighestLowest {

	public static void main(String[] args) {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("1", "One");
		treeMap.put("2", "Two");
		treeMap.put("10", "Three");
		treeMap.put("4", "Four");
		treeMap.put("5", "Five");

		System.out.println(treeMap.descendingMap());
		System.out.println(treeMap.descendingKeySet());
		System.out.println(treeMap.navigableKeySet());
		System.out.println(treeMap.firstEntry());
		System.out.println(treeMap.firstKey());
		System.out.println(treeMap.lastEntry());
		System.out.println(treeMap.lastKey());
		System.out.println(treeMap.values());
		System.out.println("########");
		treeMap.higherKey("4");

	}
}
