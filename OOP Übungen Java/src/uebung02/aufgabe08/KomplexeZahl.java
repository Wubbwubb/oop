package uebung02.aufgabe08;

public class KomplexeZahl {

	private double re;
	private double im;

	public KomplexeZahl(double real, double im) {
		this.re = real;
		this.im = im;
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

	public boolean equals(KomplexeZahl num) {
		if (getRe() == num.getRe() && getIm() == num.getIm()) {
			return true;
		}
		return false;
	};

	public KomplexeZahl add(KomplexeZahl num) {
		return new KomplexeZahl(getRe() + num.getRe(), getIm() + num.getIm());
	}

	public KomplexeZahl sub(KomplexeZahl num) {
		return new KomplexeZahl(getRe() - num.getRe(), getIm() - num.getIm());
	}

	public KomplexeZahl mul(KomplexeZahl num) {
		return new KomplexeZahl(getRe() * num.getRe() - getIm() * num.getIm(), getRe() * num.getIm() + num.getRe()
				* getIm());
	}

	public KomplexeZahl div(KomplexeZahl num) throws ArithmeticException {
		double denominator = num.getRe() * num.getRe() + num.getIm() * num.getIm();
		if (denominator == 0) {
			throw new ArithmeticException();
		}
		double re = (getRe() * num.getRe() + getIm() * num.getIm()) / denominator;
		double im = (getIm() * num.getRe() - getRe() * num.getIm()) / denominator;
		return new KomplexeZahl(re, im);
	}

}
