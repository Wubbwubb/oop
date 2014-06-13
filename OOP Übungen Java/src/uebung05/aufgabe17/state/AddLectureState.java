package uebung05.aufgabe17.state;

import java.util.Scanner;

import uebung05.aufgabe17.Console;
import uebung05.aufgabe17.Lecture;
import uebung05.aufgabe17.Room;
import uebung05.aufgabe17.Semester;

public class AddLectureState extends AbstractState implements ConsoleState {

	public AddLectureState(Scanner scanner) {
		super(scanner);
	}

	@Override
	public ConsoleState process(Console console) {
		System.out.println("Titel eingeben: ");
		String title = scanner.next();
		Semester semester = getSemester();
		System.out.println("Dozent eingeben: ");
		String docent = scanner.next();
		Room room = getRoom();
		Lecture lecture = new Lecture(title, docent, room, semester);
		console.addLecture(lecture);
		return console.START;
	}

}
