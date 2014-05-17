package uebung03.aufgabe12;

import java.util.Collection;

public abstract class Circuit implements ICircuit {

	private Collection<ICircuit> circuits;

	public Circuit(Collection<ICircuit> pCircuits) {
		if (pCircuits == null || pCircuits.isEmpty()) {
			throw new IllegalArgumentException("pCircuits must contain at least one Circuit");
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
	public int getNumberOfResistors() {
		int numberOfResistors = 0;
		for (ICircuit circuit : getCircuits()) {
			numberOfResistors += circuit.getNumberOfResistors();
		}
		return numberOfResistors;
	}

}
