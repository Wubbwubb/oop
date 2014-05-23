package uebung04.aufgabe13;

import uebung04.aufgabe13.state.AutomatState;
import uebung04.aufgabe13.state.StartState;

public class Automat {

	private AutomatState state;

	public Automat() {
		state = new StartState();
	}

	public AutomatState getState() {
		return state;
	}

	public void setState(AutomatState state) {
		this.state = state;
	}

	public void process() {
		state.process(this);
	}

}
