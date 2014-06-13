package uebung05.aufgabe17.state;

import java.util.Collection;
import java.util.Scanner;

import uebung05.aufgabe17.Console;
import uebung05.aufgabe17.Date;
import uebung05.aufgabe17.Lecture;
import uebung05.aufgabe17.Date.Day;

public class AddDateState extends AbstractState implements ConsoleState {

	public AddDateState(Scanner scanner) {
		super(scanner);
	}

	@Override
	public ConsoleState process(Console console) {
		Lecture lecture = getLecture(console.getLectures().toArray(new Lecture[console.getLectures().size()]));
		System.out.println("Tag w\u00e4hlen:");
		Day[] days = Day.values();
		for (int i = 0; i < days.length; i++) {
			System.out.println(" " + (i + 1) + " - " + days[i].name());
		}
		int index = Integer.parseInt(scanner.next()) - 1;
		Day day = days[index];
		System.out.println("Startzeit eingeben: ");
		int startTime = Integer.parseInt(scanner.next());
		Date date = null;
		try {
			date = new Date(day, startTime);
		} catch (Exception e) {
			System.out.println("Falsche Eingaben");
			return this;
		}
		Collection<Lecture> lectures = console.getLectures(lecture.getSemester(), lecture.getRoom());
		for (Lecture l : lectures) {
			for (Date d : l.getDates()) {
				if (date.isOverlapping(d)) {
					System.out.println("Der Raum " + lecture.getRoom().name() + " ist zu dieser Zeit schon belegt.");
					return this;
				}
			}
		}
		lecture.addDate(date);
		return console.START;
	}

}
