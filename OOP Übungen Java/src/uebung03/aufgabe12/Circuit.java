package uebung03.aufgabe12;

import java.util.Collection;

public abstract class Circuit implements ICircuit {

	private Collection<Resistor> resistors;

	public Circuit(Collection<Resistor> pResistors) {
		if (pResistors == null || pResistors.isEmpty()) {
			throw new IllegalArgumentException("pResistors must contain at least one Resistor");
		}
		setResistors(pResistors);
	}

	protected Collection<Resistor> getResistors() {
		return resistors;
	}

	private void setResistors(Collection<Resistor> resistors) {
		this.resistors = resistors;
	}

	@Override
	public abstract double getTotalValue();

	@Override
	public int getNumberOfResistors() {
		return getResistors().size();
	}

}
