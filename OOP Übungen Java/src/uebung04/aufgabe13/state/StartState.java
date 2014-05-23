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

		Scanner scanner = new Scanner(System.in);
		String s;
		int action = 0;
		try {
			s = scanner.nextLine();
			scanner.reset();
			action = Integer.parseInt(s);
			scanner.close();
		} catch (Exception e) {
			scanner.close();
			automat.setState(new StartState());
		}

		switch (action) {
		case 1:
			automat.setState(new ShowAutomatState());
			break;
		case 2:
			automat.setState(new MoneyInState());
			break;
		case 3:
			automat.setState(new MoneyBackState());
			break;
		case 4:
			automat.setState(new ChooseState());
			break;
		case 5:
			System.exit(0);
			break;
		default:
			automat.setState(new StartState());
			break;
		}
	}

}
