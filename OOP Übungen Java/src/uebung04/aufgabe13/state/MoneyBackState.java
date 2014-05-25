package uebung04.aufgabe13.state;

import uebung04.aufgabe13.Automat;

public class MoneyBackState implements AutomatState {

	@Override
	public void process(Automat automat) {
		System.out.println(automat.getMoney() + "€ zur\u00fcckgegeben");
		automat.resetMoney();
		automat.setState(new StartState());
	}

}
