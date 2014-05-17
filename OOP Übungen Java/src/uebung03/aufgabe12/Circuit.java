package uebung03.aufgabe12;

import java.util.Collection;

public abstract class Circuit implements ICircuit {

	private Collection<ICircuit> circuits;

	public Circuit(Collection<ICircuit> pCircuits) {
		if (pCircuits == null || pCircuits.isEmpty()) {
			throw new IllegalArgumentException("pResistors must contain at least one Resistor");
		}
		setCircuits(pCircuits);
	}

	protected Collection<ICircuit> getCircuits() {
		return circuits;
	}

	private void setCircuits(Collection<ICircuit> circuits) {
		this.circuits = circuits;
	}

	@Override
	public abstract double getTotalValue();

	@Override
	public int getNumberOfResistors() {
		return getCircuits().size();
	}

}
