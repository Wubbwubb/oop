package uebung01.aufgabe04;

public class Interval {

	private double inf;
	private double sup;

	public Interval(double pInf, double pSup) throws IllegalArgumentException {
		if (pInf > pSup) {
			throw new IllegalArgumentException("Infimum must not be smaller than Supremum!");
		}
		setInf(pInf);
		setSup(pSup);
	}

	public double getInf() {
		return inf;
	}

	private void setInf(double inf) {
		this.inf = inf;
	}

	public double getSup() {
		return sup;
	}

	private void setSup(double sup) {
		this.sup = sup;
	}

	public boolean isOverlappedBy(Interval interval) {
		return Math.max(getInf(), interval.getInf()) < Math.min(getSup(), interval.getSup());
	}

	@Override
	public String toString() {
		return "[" + getInf() + ", " + getSup() + "]";
	}

}
