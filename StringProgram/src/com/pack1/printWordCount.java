package com.pack1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class printWordCount {

	String paraString = "The oldest classical Greek and Latin writing had little or or or no spaces between words or other ones, and could be written in boustrophedon (alternating directions). Over time, text direction (left to right) became standardized, and word dividers and terminal punctuation became common.";

	public void pWordCount() {

		String modifiedString = paraString.replaceAll("\\p{Punct}", "");
		String[] paraStrArray = modifiedString.split(" ");

		Map<String, Integer> paraMap = new TreeMap<String, Integer>(
				String.CASE_INSENSITIVE_ORDER);
		for (String word : paraStrArray) {
			if (paraMap.containsKey(word)) {
				paraMap.put(word, paraMap.get(word) + 1);
			} else {
				paraMap.put(word, 1);
			}
		}

			System.out.println("*******Sorting alphabatically*******");
		for (Entry<String, Integer> entry : paraMap.entrySet()) {
			System.out.println(entry.getKey() + "==" + entry.getValue());
		}
		
		
		List<Map.Entry<String, Integer>> mapList = new LinkedList<Map.Entry<String, Integer>>(
				paraMap.entrySet());
		Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return (o1.getValue()).compareTo(o2.getValue());
				//return (o2.getKey()).compareTo(o1.getKey());
			}
		});

		// Convert sorted map back to a Map 
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : mapList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		System.out.println("**************Sorted Map with Values**************");
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		// Get the most repeated word in the string
		int maxRepeatedWord = Collections.max(sortedMap.values());
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			if (maxRepeatedWord == entry.getValue()) {
				System.out.println("Key '" + entry.getKey() + "' repeated "
						+ entry.getValue());
			}
		}

		// Get the least repeated word in the string
		int leastRepeatedWord = Collections.min(sortedMap.values());
		Set<String> leastRepeatedKeyWord = getKeyByValue(sortedMap,
				leastRepeatedWord);
		System.out.println(leastRepeatedKeyWord);
		
		
		//To the minimum values from the list
		List<String> newList = new LinkedList<String>();
		newList.add("zebra");
		newList.add("danger");
		newList.add("grapes");
		newList.add("elephant");
		
		System.out.println("Here is the Minimum value in the List :  " +Collections.min((newList)));
		
		//To get the Value based on the Key value
		
		System.out.println(getvalueByKey(sortedMap, "and"));
		
	}

	public Set<String> getKeyByValue(Map<String, Integer> map, Integer value) {
		Set<String> keys = new HashSet<String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (value == entry.getValue()) {
				// System.out.println("Key '"+entry.getKey()+"' repeated "
				// +entry.getValue());
				keys.add(entry.getKey());
			}
		}
		return keys;
	}
	
	public int getvalueByKey(Map<String, Integer> map, String key) {
		int value=0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (key.equalsIgnoreCase(entry.getKey())) {
				// System.out.println("Key '"+entry.getKey()+"' repeated "
				// +entry.getValue());
				value = entry.getValue();
			}
		}
		return value;
	}

	public static void main(String... args) {
		printWordCount p = new printWordCount();
		p.pWordCount();
	}
}
