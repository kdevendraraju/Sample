package com.pack;

//Import for Scanner
import java.util.*;

public class SampleCount {

	public static void main(String args[]) {

		String str = "this is string this can be a sample string";

		String arrayString[] = str.split(" ");
		int count = 0;

		int k = 0;
		for (int i = 0; i < arrayString.length; i++) {

			k = str.toLowerCase().indexOf(str.toLowerCase(), k + arrayString.length);

			System.out.println(k);

			if (k == -1)
				break;
			else
				count++;

		}

		System.out.println("The string occurred " + count + " times");

	}

}