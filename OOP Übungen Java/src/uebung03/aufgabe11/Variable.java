package uebung03.aufgabe11;

public class Variable implements IValueable {

	private double value;

	public Variable(double pValue) {
		this.value = pValue;
	}

	@Override
	public double getValue() {
		return value;
	}

}
