package uebung01.aufgabe04;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class IntervalChooser<T extends Interval> {

	public static void main(String[] args) {

		int numberOfIntervals = 10;
		Random r = new Random();

		System.out.println("initiale Menge:");

		LinkedList<Interval> intervals = new LinkedList<>();
		for (int i = 0; i < numberOfIntervals; i++) {
			double inf = r.nextInt(100);
			double sup = r.nextInt(100);
			if (inf > sup) {
				double tmp = inf;
				inf = sup;
				sup = tmp;
			}
			Interval interval = new Interval(inf, sup);
			intervals.add(interval);
			System.out.println(interval);
		}

		IntervalChooser<Interval> chooser = new IntervalChooser<>(intervals);

		System.out.println("\nnicht \u00fcberlappende Menge:");

		List<Interval> nonOverlappings = chooser.getNonOverlappingIntervals();
		for (Interval interval : nonOverlappings) {
			System.out.println(interval);
		}

	}

	private List<T> intervals;
	private IntervalComparator<T> comparator;

	public IntervalChooser(List<T> pIntervals) {
		setIntervals(pIntervals);
		setComparator(new IntervalComparator<T>());
	}

	public List<T> getIntervals() {
		return intervals;
	}

	private void setIntervals(List<T> intervals) {
		this.intervals = intervals;
	}

	private IntervalComparator<T> getComparator() {
		return comparator;
	}

	private void setComparator(IntervalComparator<T> comparator) {
		this.comparator = comparator;
	}

	public List<T> getNonOverlappingIntervals() {
		List<T> tmpIntervals = new LinkedList<>(getIntervals());

		Collections.sort(tmpIntervals, getComparator());

		Interval interval;
		for (int i = 0; i < tmpIntervals.size(); i++) {
			interval = tmpIntervals.get(i);
			for (int j = i + 1; j < tmpIntervals.size(); j++) {
				if (interval.isOverlappedBy(tmpIntervals.get(j))) {
					tmpIntervals.remove(j--);
				}
			}
		}
		return tmpIntervals;
	}

}
