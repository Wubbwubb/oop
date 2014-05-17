package uebung03.aufgabe12;

import java.util.Collection;

public class ParallelCircuit extends Circuit {

	public ParallelCircuit(Collection<ICircuit> pResistors) {
		super(pResistors);
	}

	@Override
	public double getTotalValue() {
		double totalValue = 0.0;
		for (ICircuit circuit : getCircuits()) {
			totalValue += (1 / circuit.getTotalValue());
		}
		return 1 / totalValue;
	}

}
