package uebung01.aufgabe04;

import java.util.Comparator;

public class IntervalComparator<T extends Interval> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if (o1.getSup() < o2.getSup() || (o1.getSup() == o2.getSup() && o1.getInf() < o2.getInf())) {
			return -1;
		}
		if (o2.getSup() < o1.getSup() || (o1.getSup() == o2.getSup() && o2.getInf() < o1.getInf())) {
			return 1;
		}
		return 0;
	}

}
