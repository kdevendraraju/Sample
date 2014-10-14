package com.pack;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapExample {

	//static String[] names = { "heman", "bob", "hhh", "shawn", "scot","shan", "keeth" };
	
	static String str = "Hello, this is an example test. Please get the count of each character of starting letter";
	static String[] names = str.split(" ");
	private static Map<Character, Integer> counter = new TreeMap<Character, Integer>();
	private static Integer cnt = null;
	public static void main(String args[]) {
		for (int i = 0; i < names.length; i++) {
			cnt = (Integer) (counter.get(new Character(names[i].charAt(0))));
			if (cnt == null) {
				counter.put(new Character(names[i].charAt(0)),new Integer("1"));
			} else {
				counter.put(new Character(names[i].charAt(0)),
						new Integer(cnt.intValue() + 1));
			}
		}
		System.out.println("\nnumber of words beginning with each letter is shown below ");
		System.out.println(counter.toString());
	}
}