package uebung04.aufgabe13.product;

public abstract class Product {

	private String name;
	private double price;

	public Product(String pName, double pPrice) {
		setName(pName);
		setPrice(pPrice);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	private void setPrice(double price) {
		this.price = price;
	}

}
