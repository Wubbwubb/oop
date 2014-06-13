package uebung05.aufgabe17.state;

import java.util.Scanner;

import uebung05.aufgabe17.Lecture;
import uebung05.aufgabe17.Room;
import uebung05.aufgabe17.Semester;

public class AbstractState {

	protected Scanner scanner;

	public AbstractState(Scanner scanner) {
		this.scanner = scanner;
	}

	protected Room getRoom() {
		System.out.println("Raum w\u00e4hlen:");
		Room[] rooms = Room.values();
		for (int i = 0; i < rooms.length; i++) {
			System.out.println(" " + (i + 1) + " - " + rooms[i].name());
		}
		int index = Integer.parseInt(scanner.next()) - 1;
		return rooms[index];
	}

	protected Semester getSemester() {
		System.out.println("Semester w\u00e4hlen:");
		Semester[] semesters = Semester.values();
		for (int i = 0; i < semesters.length; i++) {
			System.out.println(" " + (i + 1) + " - " + semesters[i].name());
		}
		int index = Integer.parseInt(scanner.next()) - 1;
		return semesters[index];
	}

	protected Lecture getLecture(Lecture[] lectures) {
		System.out.println("Vorlesung w\u00e4hlen:");
		for (int i = 0; i < lectures.length; i++) {
			System.out.println(" " + (i + 1) + " - " + lectures[i].toShortString());
		}
		int index = Integer.parseInt(scanner.next()) - 1;
		return lectures[index];
	}

}
