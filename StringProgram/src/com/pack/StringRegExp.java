package com.pack;

public class StringRegExp {
	
	public static void main(String[] args) {
	
		String str = "[Chrissman-@1]";
		String[] modifiedStr = str.replaceAll("[\\[\\]]", "").split("-@");
		System.out.println(modifiedStr[0]+ " | " +modifiedStr[1]);
		
	}

}
