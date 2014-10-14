package com.pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {

	// To count number of time a word occurs in an String
	public void wordCountInString() {
		List<String> list = new ArrayList<String>();

		// String paraString =
		// "The fishy fish Went swishy swish swish As it swam along the shore It had two baby fishes. That would fit in two dishes And who could ask for more?";
		String paraString = "Please write a program, that will take this string as an input and count the number of times a word is used. Upon completion the program will need to report the word count, in order from greatest number of occurrences, to least then ordered alphabetically as a secondary sort, as well as, the total number of words found. In the future this might be extended to include a count for the occurrences of each letter. Finally, please include test cases and expected output of the program, for the top ten words based on the sort order. The program should be named \"Program With Count For Test\".";

		String strArray[] = paraString.replaceAll("[-+.^:,\\\"]", "")
				.split(" ");

		Map<String, Integer> wordCounts = new TreeMap<String, Integer>(
				String.CASE_INSENSITIVE_ORDER);

		for (String word : strArray) {
			Integer count = wordCounts.get(word);
			if (count == null) {
				count = 0;
			}
			wordCounts.put(word, count + 1);
		}

		Map<String, Integer> sortedMap = sortByComparator(wordCounts);
		System.out.println(sortedMap);
	}
	
	private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {
		   
		  // Convert Map to List
		  List<Map.Entry<String, Integer>> list = 
		   new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
		 
		  // Sort list with comparator, to compare the Map values
		  Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
		   public int compare(Map.Entry<String, Integer> o1,
		                                           Map.Entry<String, Integer> o2) {
		    return (o1.getValue()).compareTo(o2.getValue());
		   }
		  });
		  
		  // Convert sorted map back to a Map
		  Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		  for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
		   Map.Entry<String, Integer> entry = it.next();
		   sortedMap.put(entry.getKey(), entry.getValue());
		  }
		  return sortedMap;
		  
		  
		  
	}
	
	public static void main(String[] args) {
		WordCount wc = new WordCount();
		wc.wordCountInString();
	}

}