package uebung05.aufgabe17;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

import uebung05.aufgabe17.state.AddDateState;
import uebung05.aufgabe17.state.AddLectureState;
import uebung05.aufgabe17.state.ConsoleState;
import uebung05.aufgabe17.state.OverviewState;
import uebung05.aufgabe17.state.StartState;

public class Console {

	private final Scanner scanner = new Scanner(System.in);

	public final ConsoleState START = new StartState(scanner);
	public final ConsoleState OVERVIEW = new OverviewState(scanner);
	public final ConsoleState ADD_LECTURE = new AddLectureState(scanner);
	public final ConsoleState ADD_DATE = new AddDateState(scanner);

	private ConsoleState state;
	private Collection<Lecture> lectures;

	public Console() {
		lectures = new LinkedList<>();
		state = START;
	}

	public Collection<Lecture> getLectures() {
		return lectures;
	}

	public Collection<Lecture> getLectures(Semester semester) {
		return getLectures(semester, null);
	}

	public Collection<Lecture> getLectures(Semester semester, Room room) {
		Collection<Lecture> filterList = new LinkedList<>();
		for (Lecture lecture : lectures) {
			if (lecture.getSemester() == semester) {
				if (room == null || room == lecture.getRoom()) {
					filterList.add(lecture);
				}
			}
		}
		return filterList;
	}

	public boolean addLecture(Lecture lecture) {
		return lectures.add(lecture);
	}

	public void start() {
		while (state != null) {
			state = state.process(this);
		}
		scanner.close();
	}

	public static void main(String[] args) {
		Console c = new Console();
		c.start();
	}

}
