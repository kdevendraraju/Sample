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

import org.testng.annotations.Test;

public class MapExamples {

	@Test
	public void mapTest() {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("Hello", 5);
		map.put("Apple", 3);
		map.put("Grapes", 7);
		
		List<String> mapKeyList = new ArrayList<String>(map.keySet());
		System.out.println(mapKeyList);
		for (int i = 0; i < mapKeyList.size(); i++) {
			System.out.println(mapKeyList.get(i));
		}
		
		List<Integer> mapvaluesList = new ArrayList<Integer>(map.values());
		System.out.println(mapvaluesList);
		Collections.sort(mapvaluesList);
		Collections.reverse(mapvaluesList);
		for(int i=0;i<mapvaluesList.size();i++) {
			System.out.println(mapvaluesList.get(i));
		}
	}
	
	@Test
	public static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {
			   
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
		
	}

