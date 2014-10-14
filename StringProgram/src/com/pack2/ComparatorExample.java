package com.pack2;

public class ComparatorExample {
	
	public static void main(String[] args) {
		HDTV tv1 = new HDTV(60, "Samsung");
		HDTV tv2 = new HDTV(60, "Sony");
 
		if (tv1.compareTo(tv2) > 0) {
			System.out.println(tv1.getBrand() + " is better.");
		} else {
			System.out.println(tv2.getBrand() + " is better.");
		}
	}

}
