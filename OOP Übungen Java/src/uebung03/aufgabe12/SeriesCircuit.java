package uebung03.aufgabe12;

import java.util.Collection;

public class SeriesCircuit extends AbstractCircuit {

	public SeriesCircuit(Collection<ICircuit> pCircuits) {
		super(pCircuits);
	}

	@Override
	public double getResistance() {
		double totalValue = 0.0;
		for (ICircuit circuit : getCircuits()) {
			totalValue += circuit.getResistance();
		}
		return totalValue;
	}

}
