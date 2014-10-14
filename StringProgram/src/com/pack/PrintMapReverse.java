package com.pack;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class PrintMapReverse {

	public void getReverseMap() {

		String str = "This is the test string, a hello \"print string in reverse order";
		String modifiedStr = str.replaceAll("[,.'!@#$%^&*()\"]", "");

		String[] strArray = modifiedStr.split(" ");

		Map<String, Integer> map = new TreeMap<String, Integer>(
				Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

		for (String st : strArray) {
			
			if(map.containsKey(st)) {
				map.put(st, map.get(st)+1);
			}
			else {
				map.put(st, 1);
			}
		}
		
		System.out.println(map);
	}

	public static void main(String[] args) {
		
		PrintMapReverse rmap = new PrintMapReverse();
		rmap.getReverseMap();
	}

}
