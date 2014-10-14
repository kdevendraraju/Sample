package com.pack2;

public class HDTV implements Comparable<HDTV> {
	
	private int size;
	private String brand;
 
	public HDTV(int size, String brand) {
		this.size = size;
		this.brand = brand;
	}
 
	public int getSize() {
		return size;
	}
 
	public void setSize(int size) {
		this.size = size;
	}
 
	public String getBrand() {
		return brand;
	}
 
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public int compareTo(HDTV tv) {
		// TODO Auto-generated method stub
		if (this.getSize() > tv.getSize())
			return 1;
		else if (this.getSize() < tv.getSize())
			return -1;
		else
			return 0;
	}
	

}
