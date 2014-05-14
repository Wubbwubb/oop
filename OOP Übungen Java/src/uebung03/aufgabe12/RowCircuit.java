package uebung03.aufgabe12;

import java.util.Collection;

public class RowCircuit extends Circuit {

	public RowCircuit(Collection<Resistor> pResistors) {
		super(pResistors);
	}

	@Override
	public double getTotalValue() {
		double totalValue = 0.0;
		for (Resistor resistor : getResistors()) {
			totalValue += resistor.getTotalValue();
		}
		return totalValue;
	}

}
