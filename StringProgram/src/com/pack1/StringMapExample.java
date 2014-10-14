package com.pack1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class StringMapExample {

	String paraString = "Please write a program, that will take this string as an input and count the number of times a word is used. Upon completion the program will need to report the word count, in order from greatest number of occurrences, to least then ordered alphabetically as a secondary sort, as well as, the total number of words found. In the future this might be extended to include a count for the occurrences of each letter. Finally, please include test cases and expected output of the program, for the top ten words based on the sort order. The program should be named \"program With Count For Test\".";

	Map<String, Integer> sortedMap;

	public void getWordCount() {

		String modifiedParaString = paraString.replaceAll("[-+.^:!$#%,\\\"]", "");

		String[] arrayString = modifiedParaString.split(" ");
		Map<String, Integer> map = new TreeMap<String, Integer>(
				String.CASE_INSENSITIVE_ORDER);

		for (int i = 0; i < arrayString.length; i++) {
			String key = arrayString[i];
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		// Sorting alphabetically
		System.out.println("***** Sorting alphabetically *****");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		List<Map.Entry<String, Integer>> mapList = new LinkedList<Map.Entry<String, Integer>>(
				map.entrySet());
		Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return (o1.getValue().compareTo(o2.getValue()));
			}

		});

		// Convert back the list to Map
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : mapList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		// Sorting alphabetically by value
		System.out.println("***** Sorting alphabetically By Value *****");
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

/*		// Using KeySet method
		System.out.println("Print values using key set method");
		for (String key : sortedMap.keySet())
			System.out.println(key + " = " + sortedMap.get(key));
		String searchWord = "English";
		if (sortedMap.containsKey(searchWord))
			System.out.println("Found total " + sortedMap.get(searchWord) + " "
					+ searchWord);*/

		// get the value by Key
		System.out.println("Getting Keys by passing the value");
		Set<String> keysByValue = getKeyByValue(sortedMap, 3);
		printKeys(keysByValue);

		// Get the value by passing Key
		System.out.println("Getting Value by passing the key");
		System.out.println(getValueByKey(sortedMap, "program"));

		// Get the least repeated words in the string
		System.out.println("***** Getting all the least repeated words *****");
		Set<String> leastRepeatedWords = getLeastRepeatedWords(sortedMap);
		printKeys(leastRepeatedWords);

		// Get the Most repeated words in the string
		System.out.println("***** Getting all the Most repeated words *****");
		Set<String> mostRepeatedWords = getMostRepeatedWords(sortedMap);
		printKeys(mostRepeatedWords);

		System.out.println("***** Getting the first Most repeated word *****");
		System.out.println(getFirstMostRepeatedWord(sortedMap));

		System.out
				.println("***** Getting all the Second Most repeated words *****");
		// Set<String> secondMostRepeatedWords =
		// getSecondMostRepeatedWord(sortedMap);
		// printKeys(secondMostRepeatedWords);
		
		getSecondMostRepeatedWord(sortedMap);

		System.out.println("***** Print keys in descending order");
		Set<String> keysInDescendingOrder = getKeysInDescendingOrder(sortedMap);
		printKeys(keysInDescendingOrder);

		System.out.println("***** Print keys and values in descending order");
		Map<String, Integer> wordsInDescendingOrder = getWordsInDescendingOrder(sortedMap);
		printMap(wordsInDescendingOrder);

		System.out.println("**** Get only Repeated Words**** ");
		getOnlyRepeatedWords(sortedMap);

		NavigableMap<String, Integer> onlyRepeatedWords = getOnlyRepeatedWords(sortedMap);
		printMap(onlyRepeatedWords);

		// Get repeated characters
		System.out.println("****************");
		getCharactersCount(keysInDescendingOrder);
		
		//Get the Top 10 words
		System.out.println("***** Top Ten Words *****");
		getTopTenWords(sortedMap);

	}
	
	public void printKeys(Set<String> keys) {
		for (String k : keys) {
			System.out.println(k);
		}
	}

	public void printMap(Map<String, Integer> map) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	public void printMap(NavigableMap<String, Integer> map) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	public Set<String> getKeyByValue(Map<String, Integer> map, Integer value) {

		Set<String> keysByValue = new HashSet<String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (value == entry.getValue()) {
				keysByValue.add(entry.getKey());
			}
		}

		return keysByValue;
	}


	public int getValueByKey(Map<String, Integer> map, String key) {

		int valueByKey = 0;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (key.equalsIgnoreCase(entry.getKey())) {

				valueByKey = entry.getValue();
			}
		}

		return valueByKey;
	}

	public Set<String> getLeastRepeatedWords(Map<String, Integer> sortedMap) {
		Set<String> leastRepeatedWords = new HashSet<String>();
		int leastRepeatedWordsCount = Collections.min(sortedMap.values());
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			if (leastRepeatedWordsCount == entry.getValue()) {
				leastRepeatedWords.add(entry.getKey());
			}
		}
		return leastRepeatedWords;
	}

	public Set<String> getMostRepeatedWords(Map<String, Integer> sortedMap) {
		Set<String> mostRepeatedWords = new HashSet<String>();
		int mostrepeatedWord = Collections.max(sortedMap.values());
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			if (mostrepeatedWord == entry.getValue()) {
				mostRepeatedWords.add(entry.getKey());
			}
		}

		return mostRepeatedWords;
	}

	public String getFirstMostRepeatedWord(Map<String, Integer> map) {
		String FirstMostRepeatedWord = null;

		int maxRepeated = Collections.max(map.values());
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (maxRepeated == entry.getValue()) {
				FirstMostRepeatedWord = entry.getKey();
				break;
			}
		}

		return FirstMostRepeatedWord;
	}

	//doubt
	
	public void getSecondMostRepeatedWord(Map<String, Integer> map) {
		Map<String,Integer> secondMap = map;
		Set<String> mostRepeatedWords = getMostRepeatedWords(secondMap);
		secondMap.keySet().removeAll(mostRepeatedWords);
		
		Set<String> secondMostRepeatedWords = getMostRepeatedWords(secondMap);
		System.out.println(secondMostRepeatedWords);
	}

	public NavigableSet<String> getKeysInDescendingOrder(
			Map<String, Integer> map) {
		NavigableMap<String, Integer> navMap = new TreeMap<String, Integer>(map);

		return navMap.descendingKeySet();
		// System.out.println(navMap.descendingMap());
	}

	public NavigableMap<String, Integer> getWordsInDescendingOrder(
			Map<String, Integer> map) {
		NavigableMap<String, Integer> navMap = new TreeMap<String, Integer>(map);
		return navMap.descendingMap();
	}

	public NavigableMap<String, Integer> getOnlyRepeatedWords(
			Map<String, Integer> map) {
		NavigableMap<String, Integer> navMap = new TreeMap<String, Integer>(map);
		for (Map.Entry<String, Integer> entry : navMap.entrySet()) {
			if (entry.getValue() != 1) {
				navMap.put(entry.getKey(), entry.getValue());
			}
		}

		return navMap;
	}

	//doubt
	public void getTopTenWords(Map<String, Integer> map) {

		List<Map.Entry<String, Integer>> wordsList = new LinkedList<Map.Entry<String, Integer>>(
				map.entrySet());
		Map<String,Integer> topTenWordsmap = new TreeMap<String,Integer>();
		
		for (Map.Entry<String, Integer> entry : wordsList.subList(0, 10)) {

			System.out.println(entry.getKey()+ " = " +entry.getValue());

		}

	}

	public void getCharactersCount(Set<String> setWords) {
		
		  String str = setWords.toString(); System.out.println(str);
		 
		String modifiedStr = str.replaceAll("[,. \\\"\\]\\[]", "");
		char ch[] = modifiedStr.toCharArray();
		Map<Character, Integer> charMap = new TreeMap<Character, Integer>();
		for (int i = 0; i < ch.length; i++) {
			char charKey = ch[i];
			if (charMap.containsKey(charKey)) {
				charMap.put(charKey, charMap.get(charKey) + 1);
			} else {
				charMap.put(charKey, 1);
			}
		}

		System.out.println(charMap);
	}

	public static void main(String[] args) {

		StringMapExample m = new StringMapExample();
		m.getWordCount();
	}
}
