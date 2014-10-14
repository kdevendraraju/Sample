package com.pack;

import java.util.HashMap;

public class DupeCharactersCount {

	 public static void main(String[] args) {
         // TODO Auto-generated method stub

   String str = "Character duplicate word example java";
   String modifiedStr = str.replaceAll("[ ',]", "");
   char ch1[]=modifiedStr.toCharArray();
   HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
   for(int i=0; i<ch1.length; i++)
   {
       char ch=ch1[i];
       hm.put(ch,(hm.get(ch)==null?1:hm.get(ch)+1));
   }
 
   System.out.println("No of Characters are : "+hm);
  
  

  }

}
