package com.pack;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class DuplicateCharacters {

	public void findDuplicateChars(String str) {

		Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
		char[] chrs = str.toCharArray();
		for (Character ch : chrs) {
			if (dupMap.containsKey(ch)) {
				dupMap.put(ch, dupMap.get(ch) + 1);
			} else {
				dupMap.put(ch, 1);
			}
		}
		Set<Character> keys = dupMap.keySet();
		for (Character ch : keys) {
			if (dupMap.get(ch) > 1) {
				System.out.println(ch + "--->" + dupMap.get(ch));
			}
		}
	}

	public void duplicateChars() {

		String str = "thisjhgisastring";
		char[] chars = str.toCharArray();
		Map<Character, Integer> countOfChars = new TreeMap<Character, Integer>();
		for (int i = 0; i < chars.length; i++) {
			if (countOfChars.containsKey(chars[i])) {

				countOfChars.put(chars[i], countOfChars.get(chars[i]) + 1);
			} else {
				countOfChars.put(chars[i], 1);
			}
		}

		for (Character entry : countOfChars.keySet()) {
			if(countOfChars.get(entry) > 1) {
				System.out.println(entry + " = " + countOfChars.get(entry));
			}
		}

	}

	public static void main(String a[]) {
		DuplicateCharacters dcs = new DuplicateCharacters();
		dcs.findDuplicateChars("Java2Novice");
		dcs.duplicateChars();
	}
}
