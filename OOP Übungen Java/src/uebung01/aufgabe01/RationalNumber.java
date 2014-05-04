package uebung01.aufgabe01;

/**
 * Diese Klasse repr&auml;sentiert rationale Zahlen. Da rationale Zahlen durch Br&uuml;che dargestellt werden
 * k&ouml;nnen, werden intern zwei ganze Zahlen (Z&auml;hler und Nenner) gespeichert. Diese beiden Zahlen werden als
 * long abgespeichert, um den Wertebereich m&ouml;glichst gro&szlig; zu gestalten.
 *
 * @author Maximilian Schmitt
 */
public class RationalNumber implements Comparable<RationalNumber> {

	public static void main(String[] args) {
		RationalNumber rn1 = new RationalNumber(3, 5);
		RationalNumber rn2 = new RationalNumber(15, 11);
		RationalNumber rn3 = rn1.multiply(rn2);
		System.out.println(rn3.toString());
	}

	private long numerator;
	private long denominator;

	public RationalNumber(long pNumerator, long pDenominator) {
		// Nenner darf nicht 0 sein
		if (pDenominator == 0) {
			throw new IllegalArgumentException("Denominator must be != 0!");
		}

		setNumerator(pNumerator);
		setDenominator(pDenominator);

		// Alle Objekte sind zu jeder Zeit gekuerzt
		reduce();
	}

	public long getNumerator() {
		return numerator;
	}

	private void setNumerator(long numerator) {
		this.numerator = numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	private void setDenominator(long denominator) {
		this.denominator = denominator;
	}

	public double getDecimalValue() {
		return (double) getNumerator() / (double) getDenominator();
	}

	public RationalNumber add(RationalNumber r) {
		return new RationalNumber((getNumerator() * r.getDenominator()) + (r.getNumerator() * getDenominator()),
				getDenominator() * r.getDenominator());
	}

	public RationalNumber subtract(RationalNumber r) {
		return add(new RationalNumber(-r.getNumerator(), r.getDenominator()));
	}

	public RationalNumber multiply(RationalNumber r) {
		return new RationalNumber(getNumerator() * r.getNumerator(), getDenominator() * r.getDenominator());
	}

	public RationalNumber divide(RationalNumber r) {
		// Division durch 0 ist nicht erlaubt
		if (r.getNumerator() == 0) {
			throw new IllegalArgumentException("Division by 0 is not possible!");
		}
		return multiply(new RationalNumber(r.getDenominator(), r.getNumerator()));
	}

	private void reduce() {
		long numerator = getNumerator();
		long denominator = getDenominator();
		if (numerator == 0) {
			setDenominator(1);
			return;
		}
		long factor = ggt(Math.abs(numerator), Math.abs(denominator));
		numerator /= factor;
		denominator /= factor;
		setNumerator(numerator);
		setDenominator(denominator);
		if (numerator < 0) {
			setNumerator(-numerator);
			setDenominator(-denominator);
		}
	}

	private static long ggt(long a, long b) {
		return (b == 0) ? a : ggt(b, a % b);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RationalNumber) {
			// Zwei Objekte sind genau dann gleich, wenn die Dezimalwerte gleich sind
			return getDecimalValue() == ((RationalNumber) obj).getDecimalValue();
		}
		return false;
	}

	@Override
	public String toString() {
		return getNumerator() + "/" + getDenominator() + " (" + getDecimalValue() + ")";
	}

	@Override
	public int compareTo(RationalNumber r) {
		double decimal = getDecimalValue();
		double decimalR = r.getDecimalValue();
		if (decimal < decimalR) {
			return -1;
		}
		if (decimal > decimalR) {
			return 1;
		}
		return 0;
	}

}
