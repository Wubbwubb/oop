package uebung03.aufgabe12;

public class Resistor implements ICircuit {

	private double value;

	public Resistor(double pValue) {
		if (pValue == 0.) {
			throw new IllegalArgumentException("pValue must not be zero");
		}
		value = pValue;
	}

	@Override
	public double getTotalValue() {
		return value;
	}

	@Override
	public int getNumberOfResistors() {
		return 1;
	}

}
