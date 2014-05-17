package uebung03.aufgabe12;

import java.util.Collection;

public class RowCircuit extends Circuit {

	public RowCircuit(Collection<ICircuit> pResistors) {
		super(pResistors);
	}

	@Override
	public double getTotalValue() {
		double totalValue = 0.0;
		for (ICircuit circuit : getCircuits()) {
			totalValue += circuit.getTotalValue();
		}
		return totalValue;
	}

}
