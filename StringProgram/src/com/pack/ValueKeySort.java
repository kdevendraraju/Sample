package com.pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ValueKeySort {

	public void wordCountOfString() {

		List<String> list = new ArrayList<String>();

		String paraString = "Please write a program, that will take this string as an input and count the number of times a word is used. Upon completion the program will need to report the word count, in order from greatest number of occurrences, to least then ordered alphabetically as a secondary sort, as well as, the total number of words found. In the future this might be extended to include a count for the occurrences of each letter. Finally, please include test cases and expected output of the program, for the top ten words based on the sort order. The program should be named \"program With Count For Test\".";

		String result = paraString.replaceAll("[-+.^:,\\\"]", "");

		String strArray[] = result.split(" ");
		for (int i = 0; i < strArray.length; i++) {
			list.add(strArray[i]);
		}

		Map<String, Integer> wordCountofString = new TreeMap<String, Integer>(
				String.CASE_INSENSITIVE_ORDER);

		/*
		 * for (String word: strArray) { if
		 * (wordCountofString.containsKey(word)) { // Map already contains the
		 * word key. Just increment it's count by 1 wordCountofString.put(word,
		 * wordCountofString.get(word) + 1); } else { // Map doesn't have
		 * mapping for word. Add one with count = 1 wordCountofString.put(word,
		 * 1); } }
		 */

		for (int i = 0; i < strArray.length; i++) {
			if (wordCountofString.containsKey(strArray[i])) {
				// Map already contains the word key. Just increment it's count
				// by 1
				wordCountofString.put(strArray[i],
						wordCountofString.get(strArray[i]) + 1);
			} else {
				// Map doesn't have mapping for word. Add one with count = 1
				wordCountofString.put(strArray[i], 1);
			}
		}

		System.out.println("****************************************");
		for (Map.Entry<String, Integer> entry : wordCountofString.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	public static void main(String[] args) {

		ValueKeySort sort = new ValueKeySort();
		sort.wordCountOfString();
	}
}
