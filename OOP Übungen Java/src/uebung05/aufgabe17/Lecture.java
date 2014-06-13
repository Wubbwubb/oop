package uebung05.aufgabe17;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Lecture {

	private String name;
	private String docent;
	private Room room;
	private Semester semester;
	private Collection<Date> dates;

	public Lecture(String name, String docent, Room room, Semester semester) {
		this.name = name;
		this.docent = docent;
		this.room = room;
		this.semester = semester;
		dates = new LinkedHashSet<>();
	}

	public Room getRoom() {
		return room;
	}

	public Semester getSemester() {
		return semester;
	}

	public Collection<Date> getDates() {
		return dates;
	}

	public boolean addDate(Date date) {
		return dates.add(date);
	}

	public String toShortString() {
		return name + ", " + semester.name() + ", " + docent + ", " + room.name() + "\n";
	}

	@Override
	public String toString() {
		String s = "title: " + name;
		s += "\nsemester: " + semester.name();
		s += "\ndocent: " + docent;
		s += "\nroom: " + room.name();
		s += "\ndates:\n";
		for (Date date : dates) {
			s += " - " + date.toString() + "\n";
		}
		return s;
	}

}
