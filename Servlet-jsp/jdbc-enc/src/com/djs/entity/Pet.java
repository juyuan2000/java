package com.djs.entity;

public class Pet {
	int id;
	String kind;
	String color;
	double price;
	
	public Pet (int id,String kind,String color) {
		this.id = id;
		this.kind = kind;
		this.color = color;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getKind() {
		return kind;
	}



	public void setKind(String kind) {
		this.kind = kind;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Pet [id=" + id + ", kind=" + kind + ", color=" + color + ", price=" + price + "]";
	}
	
	

}
