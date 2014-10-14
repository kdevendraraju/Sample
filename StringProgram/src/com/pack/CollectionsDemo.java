package com.pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionsDemo {

	public static void main(String[] args) {
		List<String> a1 = new ArrayList<String>();
		a1.add("Beginner");
		a1.add("Java");
		a1.add("tutorial");
		System.out.println(" ArrayList Elements");
		System.out.print("\t" + a1);
		List<String> l1 = new LinkedList<String>();
		l1.add("Beginner");
		l1.add("Java");
		l1.add("tutorial");
		System.out.println();
		System.out.println(" LinkedList Elements");
		System.out.print("\t" + l1);
		Set<String> s1 = new HashSet<String>(); // or new TreeSet() will order the elements;
		s1.add("Beginner");
		s1.add("Java");
		s1.add("Java");
		s1.add("tutorial");
		System.out.println();
		System.out.println(" Set Elements");
		System.out.print("\t" + s1);
		Map<String, String> m1 = new TreeMap<String, String>(); // or new TreeMap() will order based on keys
		m1.put("Windows", "98");
		m1.put("Win", "XP");
		m1.put("Beginner", "Java");
		m1.put("Tutorial", "Site");
		System.out.println();
		System.out.println(" Map Elements");
		System.out.print("\t" + m1);
	}
}