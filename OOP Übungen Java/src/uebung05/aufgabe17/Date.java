package uebung05.aufgabe17;

public class Date implements Comparable<Date> {

	public static enum Day {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
	}

	private static int DATE_LENGTH = 2;

	private Day day;
	private int startTime;

	public Date(Day day, int startTime) {
		if (startTime < 0 || startTime > 23 - DATE_LENGTH) {
			throw new IllegalArgumentException();
		}
		this.day = day;
		this.startTime = startTime;
	}

	public boolean isOverlapping(Date a) {
		if (day == a.day) {
			if (Math.abs(startTime - a.startTime) < DATE_LENGTH) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hc = 17;
		int multiplier = 59;
		hc = (hc * multiplier) + day.hashCode();
		hc = (hc * multiplier) + startTime;
		return hc;
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass().equals(obj.getClass())) {
			Date a = (Date) obj;
			if (day == a.day && startTime == a.startTime) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return day.name() + ", " + startTime + " - " + (startTime + DATE_LENGTH);
	}

	@Override
	public int compareTo(Date o) {
		if (day.ordinal() == o.day.ordinal()) {
			if (startTime == o.startTime) {
				return 0;
			}
			return startTime - o.startTime;
		}
		return day.ordinal() - o.day.ordinal();
	}

}
