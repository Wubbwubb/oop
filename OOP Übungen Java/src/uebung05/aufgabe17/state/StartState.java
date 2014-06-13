package uebung05.aufgabe17.state;

import java.util.Scanner;

import uebung05.aufgabe17.Console;

public class StartState extends AbstractState implements ConsoleState {

	public StartState(Scanner scanner) {
		super(scanner);
	}

	@Override
	public ConsoleState process(Console console) {
		System.out.println("Aktion w\u00e4hlen:");
		System.out.println(" 1 - Semester\u00fcbersicht anzeigen");
		System.out.println(" 2 - Vorlesung erstellen");
		System.out.println(" 3 - Termin eintragen");
		System.out.println(" 4 - ausschalten");

		String s = scanner.next();

		switch (s) {
		case "1":
			return console.OVERVIEW;
		case "2":
			return console.ADD_LECTURE;
		case "3":
			return console.ADD_DATE;
		case "4":
			return null;
		default:
			return this;
		}
	}

}
