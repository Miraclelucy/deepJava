package thinkinginJava.Strategy;

public class Product {
	private double Price;
	private String name;
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product(){}
	public Product(String name,double price){
		this.name=name;
		this.Price=price;
	}
	
}
