package uebung04.aufgabe13.state;

import uebung04.aufgabe13.Automat;

public class TooLessMoneyState implements AutomatState {

	@Override
	public void process(Automat automat) {
		System.out.println("nicht genug Geld eingeworfen");
		automat.setState(new StartState());
	}

}
