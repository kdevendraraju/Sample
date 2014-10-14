package com.pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StringWordCount {
	public static void main(String args[])
	{
		String sText = 
			"Please write a program, that will take this string as an input and count the number of times a word is used. Upon completion the program will need to report the word count, in order from greatest number of occurrences, to least then ordered alphabetically as a secondary sort, as well as, the total number of words found. In the future this might be extended to include a count for the occurrences of each letter. Finally, please include test cases and expected output of the program, for the top ten words based on the sort order. The program should be named \"Program With Count For Test";

		String sTxtArray[] = sText.split(" ");
		Map<String,Integer> objMap = new HashMap<String,Integer>();
		Map<String,Integer> objTreeMap = new TreeMap<String,Integer>();
		System.out.println("String Contents displayed: ");
		
		ArrayList<String> sArryList = new ArrayList<String>();;
	    for(int iCounter=0; iCounter<sTxtArray.length; iCounter++)
		{

			sArryList.add(sTxtArray[iCounter]);
		}
	    
	    System.out.println("****************************************");
		
		System.out.println(sArryList);
		
		System.out.println("****************************************");
		int iSize = sArryList.size();
		System.out.println("Word Count of String:"+ iSize);
		System.out.println("****************************************");
		int count = 0;
		int iCounter;
		
	    for(iCounter=0; iCounter<sTxtArray.length; iCounter++)
		{
	    	count =0;
	    	String sTextNew = sTxtArray[iCounter];
	    	for(int iCounter1=0;iCounter1<sTxtArray.length; iCounter1++)
	    	{
	    		if(sTextNew.equalsIgnoreCase(sTxtArray[iCounter1]))
	    		{
	    			count = count + 1;
	    		}

	    	}
	    	System.out.println(sTxtArray[iCounter]+ "=" + count);
	    	objMap.put(sTextNew, count);
	    	objTreeMap.put(sTextNew, count);
		}
	    System.out.println(sTxtArray[iCounter]+ "=" + count);
	    
	    //System.out.println(objMap);
		System.out.println("****************************************");
	    System.out.println(objTreeMap);
		System.out.println("****************************************");
	    System.out.println(entriesSortedByValues(objTreeMap));
	    
		
	}
	
	
  static <K,V extends Comparable<? super V>> 
	    List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {
	
	List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());
	
	Collections.sort(sortedEntries, 
	    new Comparator<Entry<K,V>>() {
	        public int compare(Entry<K,V> e1, Entry<K,V> e2) {
	            return e2.getValue().compareTo(e1.getValue());
	        }
	    }
	);
	
	return sortedEntries;
	}
}