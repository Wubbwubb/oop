package uebung04.aufgabe13.state;

import uebung04.aufgabe13.Automat;

public class ShowAutomatState implements AutomatState {

	@Override
	public void process(Automat automat) {
		
		
		
		automat.setState(new StartState());
	}

}
