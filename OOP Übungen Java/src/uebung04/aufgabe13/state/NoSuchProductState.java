package uebung04.aufgabe13.state;

import uebung04.aufgabe13.Automat;

public class NoSuchProductState implements AutomatState {

	@Override
	public void process(Automat automat) {
		System.out.println("Es gibt kein Produkt mit der eingegebenen Nummer");
		automat.setState(new StartState());
	}

}
