package com.pack;


import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CountOfWords {
	
	public void getCount() {
		String str = "hello, this paragraph is do test paragraph. Did you like that?. how do you want me to do that.";
		String modifiedString = str.replace("\\p{Punct}", " ");
		System.out.println(modifiedString);
		String[] strArray = modifiedString.split(" ");
		
		Map<String, Integer> countWords = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		
		for (int i = 0; i < strArray.length; i++) {
			
			Integer count = countWords.get(strArray[i]);
			if(count==null)
			{
				count=0;
			}
			countWords.put(strArray[i], count+1);
		}
		
		System.out.println(countWords);
		
		for (Map.Entry<String, Integer> entry : countWords.entrySet()) {
			String key=entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " = " + value);
		}
		
		//To print the word which is repeated for the most maximum number of the times in given string
		int maxValue = Collections.max(countWords.values());
		System.out.println("This is the max value" +maxValue);
		
		for (Entry<String, Integer> entry : countWords.entrySet()) {  // Iterate through hashmap
            if (entry.getValue()==maxValue) {
                System.out.println("Key '"+entry.getKey()+"' repeated " +maxValue+ "time(s)");     // Print the key with max value
            }
        }
		
		//To print the word which is repeated for the minimum number of the times in given string
		int minValue = Collections.min(countWords.values());
		for(Entry<String,Integer> entry : countWords.entrySet()) {
			if(entry.getValue()==minValue) {
				System.out.println("Key "+entry.getKey()+" repeated " +minValue);
			}
		}
		
		
	}
	

	public static void main(String[] args) {
		CountOfWords c = new CountOfWords();
		c.getCount();
	}
}
