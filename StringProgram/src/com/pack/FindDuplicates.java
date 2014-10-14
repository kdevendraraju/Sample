package com.pack;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FindDuplicates {
	
    public static void main(String[] args) {
        Set<String> uniques = new HashSet<String>();
        Set<String> dups    = new TreeSet<String>();
 
        String str = "a hey this is sent is hey";
        String[] strArray = str.split(" ");
        for (String a : strArray)
            if (!uniques.add(a))
                dups.add(a);
 
        // Destructive set-difference
        uniques.removeAll(dups);
 
        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
}