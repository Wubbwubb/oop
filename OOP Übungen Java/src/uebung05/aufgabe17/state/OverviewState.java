package uebung05.aufgabe17.state;

import java.util.Collection;
import java.util.Scanner;

import uebung05.aufgabe17.Console;
import uebung05.aufgabe17.Lecture;
import uebung05.aufgabe17.Semester;

public class OverviewState extends AbstractState implements ConsoleState {

	public OverviewState(Scanner scanner) {
		super(scanner);
	}

	@Override
	public ConsoleState process(Console console) {
		System.out.println("Semester w\u00e4hlen:");
		Semester[] semesters = Semester.values();
		for (int i = 0; i < semesters.length; i++) {
			System.out.println(" " + (i + 1) + " - " + semesters[i].name());
		}
		int index = Integer.parseInt(scanner.next()) - 1;
		Collection<Lecture> lectures = console.getLectures(semesters[index]);
		for (Lecture lecture : lectures) {
			System.out.println(lecture.toString());
		}
		return console.START;
	}
}
