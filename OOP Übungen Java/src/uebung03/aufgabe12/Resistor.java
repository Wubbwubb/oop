package uebung03.aufgabe12;

public class Resistor implements ICircuit {

	private double resistance;

	public Resistor(double pResistance) {
		if (pResistance == 0.) {
			throw new IllegalArgumentException("pResistance must not be zero");
		}
		resistance = pResistance;
	}

	@Override
	public double getResistance() {
		return resistance;
	}

	@Override
	public int getNumberOfResistors() {
		return 1;
	}

}
