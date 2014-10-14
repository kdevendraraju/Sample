package com.pack;

public class SpecialCharactersCount {

	public void getSplCharctersCount() {

		String str = "One$ two$three$ four! five@six$";

		int count = str.length() - str.replaceAll("\\$", "").length();

		System.out.println("Done:" + count);
		
		  int fullLength = str.length();
          String modifiedString = str.replaceAll("\\p{Punct}","");
          System.out.println(modifiedString);
          int modStringLength = modifiedString.length();
          
          int numberOfSpecialChars = fullLength - modStringLength;
          System.out.println("No of spl characters" +numberOfSpecialChars);
          
          
          String modifiedStringExcept = str.replaceAll("[\\p{Punct}&&[^$]]","");
          int modifiedStringExceptlength = modifiedStringExcept.length();
          int numberOfSpecialCharsExcept = fullLength - modifiedStringExceptlength;
          System.out.println("No of spl except  " +numberOfSpecialCharsExcept);
          

	}
	
	public void noOfCommas() {
		String helloWorld = "this is , a test$, string,";
		int commas = 0;
		int ampercent =0;
		for(int i = 0; i < helloWorld.length(); i++) {
		    if(helloWorld.charAt(i) == ',') commas++;
		    
			if(helloWorld.charAt(i) == '$') ampercent++;
		}

		System.out.println("String has " + commas + " commas!");
		System.out.println("String has " + ampercent + " ampercenst!");
		
		String strhello = helloWorld.replaceAll("\\,", "");
		int countofCommas = helloWorld.length()  - strhello.length();
		System.out.println("Total commas " +countofCommas);
	}

	public void getEachSplCharCount() {

		String str = "one$ two$ three$ four!five@six$";
		int i, c1 = 0, c2 = 0, c3 = 0, sp = 0;
		char ch;
		
		String[] arr = str.split(" ");
		System.out.println("No of words "+arr.length);
		
		for (i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (Character.isLetter(ch))
				++c1;
			else if (Character.isDigit(ch))
				++c2;
			else if (ch == ' ')
				++sp;
			else
				++c3;
		}
		
		System.out.println("no of Letter=" + c1);
		System.out.println("no of Digit=" + c2);
		System.out.println("no of Spaces=" + sp);
		System.out.println("no of Symbol=" + c3);
	}

	public static void main(String[] args) {

		SpecialCharactersCount sp = new SpecialCharactersCount();
		sp.getSplCharctersCount();
		sp.getEachSplCharCount();
		sp.noOfCommas();
	}
}
