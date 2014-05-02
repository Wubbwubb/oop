package uebung01.aufgabe01;

public class RationalNumber {

	public static void main(String[] args) {
		RationalNumber rn1 = new RationalNumber(2, 6);
		RationalNumber rn2 = new RationalNumber(3, 4);
		RationalNumber rn3 = rn1.add(rn2);
		System.out.println(rn3.getNumerator() + "/" + rn3.getDenominator() + " (" + rn3.getDecimalValue() + ")");
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
		return multiply(new RationalNumber(getDenominator(), getNumerator()));
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

}
