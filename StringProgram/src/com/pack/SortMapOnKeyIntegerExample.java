package com.pack;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortMapOnKeyIntegerExample {

	public static void main(String[] args) {

		Map<Integer, String> unsortMap = new HashMap<Integer, String>();
		unsortMap.put(10, "z");
		unsortMap.put(5, "b");
		unsortMap.put(6, "a");
		unsortMap.put(20, "c");
		unsortMap.put(1, "d");
		unsortMap.put(7, "e");
		unsortMap.put(8, "y");
		unsortMap.put(99, "n");
		unsortMap.put(50, "j");
		unsortMap.put(2, "m");
		unsortMap.put(9, "f");

		System.out.println("Unsort Map......");
		printMapKey(unsortMap);
		System.out.println("With new method");
		
		System.out.println("\nSorted Map of Key......");
		Map<Integer, String> treeMapKey = new TreeMap<Integer, String>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}
				});
		treeMapKey.putAll(unsortMap);
		printMapKey(treeMapKey);
		
		System.out.println(".........");
		Map<Integer,String> sortedMapByValues = sortByCompare(unsortMap);

		System.out.println("Sorted map by Values alphabatically");
		printMapKey(sortedMapByValues);
	}

	public static void printMapKey(Map<Integer, String> map) {
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
		}
	}

	public static Map<Integer, String> sortByCompare(
			Map<Integer, String> unsortMap) {
		List<Map.Entry<Integer, String>> valuesList = new LinkedList<Map.Entry<Integer, String>>(
				unsortMap.entrySet());

		Collections.sort(valuesList,
				new Comparator<Map.Entry<Integer, String>>() {
					@Override
					public int compare(Entry<Integer, String> o1,
							Entry<Integer, String> o2) {
						return (o1.getValue()).compareTo(o2.getValue());

					}
				});

		Map<Integer, String> sortedMapValues = new LinkedHashMap<Integer, String>();
		for (Iterator<Entry<Integer, String>> iterator = valuesList.iterator(); iterator
				.hasNext();) {
			Entry<Integer, String> entry = iterator.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			sortedMapValues.put(key, value);
			// System.out.println(key+ " = " + value);
		}
		return sortedMapValues;

	}

}
