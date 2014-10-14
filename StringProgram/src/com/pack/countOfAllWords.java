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

public class countOfAllWords {

	// To count number of time a word occurs in an String
	public void wordCountInString(String wordString) {
		List<String> list = new ArrayList<String>();

		String paraString = "Please write a program, that will take this string as an input and count the number of times a word is used. Upon completion the program will need to report the word count, in order from greatest number of occurrences, to least then ordered alphabetically as a secondary sort, as well as, the total number of words found. In the future this might be extended to include a count for the occurrences of each letter. Finally, please include test cases and expected output of the program, for the top ten words based on the sort order. The program should be named \"program With Count For Test\".";

		String result = paraString.replaceAll("[-+.^:,\\\"]", "");

		String strArray[] = result.split(" ");
		for (int i = 0; i < strArray.length; i++) {
			list.add(strArray[i]);
		}

		// To print the count of the word
		System.out.println("Word '" + wordString + "' found "
				+ Collections.frequency(list, wordString) + " time(s)");
		
		
		// To print the count for all the string occurrences
		Map<String, Integer> wordCounts = new TreeMap<String, Integer>(
				String.CASE_INSENSITIVE_ORDER);

		for (String word : strArray) {
			Integer count = wordCounts.get(word);
			if (count == null) {
				count = 0;
			}
			wordCounts.put(word, count + 1);
		}

		System.out.println("Word count of all the strings in paragraph sorted Alphabatically:");
		System.out.println(wordCounts);
		
		System.out.println("Word count of all the strings in paragraph sorted on Count:");
		//Getting the sorted map
		Map<String, Integer> sortedMap = sortByComparator(wordCounts);
		System.out.println(sortedMap);
		
/*		System.out.println("Sort on Keys...");
		
		Map<String, Integer> treeMapKey = new TreeMap<String, Integer>(
				new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						return o2.compareTo(o1);
					}
				});
		
		treeMapKey.putAll(wordCounts);
		System.out.println(wordCounts);*/
		

	}
	
	private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {
		   
		  // Convert Map to List
		  List<Map.Entry<String, Integer>> list = 
		   new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
		
		  
		 
		  // Sort list with comparator, to compare the Map values
		  //Sorts the elements of list as determined by comparator.
		  Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
		   public int compare(Map.Entry<String, Integer> o1,
		                                           Map.Entry<String, Integer> o2) {
		    return (o2.getValue()).compareTo(o1.getValue());
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
		countOfAllWords wc = new countOfAllWords();
		wc.wordCountInString("count");
	}

}