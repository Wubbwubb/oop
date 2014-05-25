package uebung04.aufgabe13.state;

import uebung04.aufgabe13.Automat;
import uebung04.aufgabe13.product.Product;

public class GiveOutState implements AutomatState {

	private Product product;

	public GiveOutState(Product product) {
		this.product = product;
	}

	@Override
	public void process(Automat automat) {
		System.out.println("Produkt ausgeben: " + product.toString());
		automat.addMoney(-product.getPrice());
		automat.setState(new StartState());
	}

}
