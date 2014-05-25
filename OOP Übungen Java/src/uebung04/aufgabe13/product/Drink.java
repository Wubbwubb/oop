package uebung04.aufgabe13.product;

public class Drink extends Product {

	private double volume;

	public Drink(String pName, double pPrice, double pVolume) {
		super(pName, pPrice);
		setVolume(pVolume);
	}

	public double getVolume() {
		return volume;
	}

	private void setVolume(double weight) {
		this.volume = weight;
	}

	@Override
	public String toString() {
		return getName() + ", " + getVolume() + "l, " + getPrice() + "€";
	}

}
