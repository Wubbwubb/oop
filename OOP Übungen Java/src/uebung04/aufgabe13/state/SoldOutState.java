package uebung04.aufgabe13.state;

import uebung04.aufgabe13.Automat;

public class SoldOutState implements AutomatState {

	@Override
	public void process(Automat automat) {
		System.out.println("Das Produkt ist ausverkauft");
		automat.setState(new StartState());
	}

}
