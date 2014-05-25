package uebung04.aufgabe13.product;

public class Candy extends Product {

	private double weight;

	public Candy(String pName, double pPrice, double pWeight) {
		super(pName, pPrice);
		setWeight(pWeight);
	}

	public double getWeight() {
		return weight;
	}

	private void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return getName() + ", " + getWeight() + "g, " + getPrice() + "€";
	}

}
