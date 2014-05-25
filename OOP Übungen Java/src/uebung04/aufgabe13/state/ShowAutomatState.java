package uebung04.aufgabe13.state;

import uebung04.aufgabe13.Automat;

public class ShowAutomatState implements AutomatState {

	@Override
	public void process(Automat automat) {

		System.out.println(automat.toString());

		automat.setState(new StartState());
	}

}
