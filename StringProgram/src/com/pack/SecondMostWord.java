package com.pack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class SecondMostWord {
	
	
	@Test
	public void getSecondMostRepeatedWord() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "4");
		map.put("b", "4");
		map.put("c", "2");
		map.put("d", "3");
		map.put("e", "3");

		Set<String> set = new HashSet<> ();
		set.add("a");
		set.add("b");

		map.keySet().removeAll(set);

		System.out.println(map); 

	}

	
}
