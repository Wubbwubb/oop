package uebung03.aufgabe12;

import java.util.Collection;

public class ParallelCircuit extends Circuit {

	public ParallelCircuit(Collection<Resistor> pResistors) {
		super(pResistors);
	}

	@Override
	public double getTotalValue() {
		double totalValue = 0.0;
		for (Resistor resistor : getResistors()) {
			totalValue += (1 / resistor.getTotalValue());
		}
		return 1 / totalValue;
	}

}
