package uebung04.aufgabe13.state;

import java.util.Scanner;

import uebung04.aufgabe13.Automat;

public class StartState implements AutomatState {

	@Override
	public void process(Automat automat) {
		System.out.println("Aktion w\u00e4hlen:");
		System.out.println(" 1 - Automat anzeigen");
		System.out.println(" 2 - Geld einwerfen");
		System.out.println(" 3 - Geld zur\u00fcckgeben");
		System.out.println(" 4 - Produkt ausw\u00e4hlen");
		System.out.println(" 5 - ausschalten");

		String s = new Scanner(System.in).next();

		switch (s) {
		case "1":
			automat.setState(new ShowAutomatState());
			break;
		case "2":
			automat.setState(new MoneyInState());
			break;
		case "3":
			automat.setState(new MoneyBackState());
			break;
		case "4":
			automat.setState(new ChooseState());
			break;
		case "5":
			System.exit(0);
			break;
		default:
			automat.setState(this);
			break;
		}
	}

}
