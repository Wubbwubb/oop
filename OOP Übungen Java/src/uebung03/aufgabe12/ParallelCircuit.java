package uebung03.aufgabe12;

import java.util.Collection;

public class ParallelCircuit extends AbstractCircuit {

	public ParallelCircuit(Collection<ICircuit> pCircuits) {
		super(pCircuits);
	}

	@Override
	public double getResistance() {
		double totalValue = 0.0;
		for (ICircuit circuit : getCircuits()) {
			totalValue += (1 / circuit.getResistance());
		}
		return 1 / totalValue;
	}

}
