package uebung03.aufgabe12;

import java.util.Collection;
import java.util.LinkedList;

public class TestCircuit {

	public static void main(String[] args) {

		Resistor r1 = new Resistor(2.0);
		Resistor r2 = new Resistor(4.0);

		Collection<Resistor> resistors = new LinkedList<>();
		resistors.add(r1);
		resistors.add(r2);

		RowCircuit rc1 = new RowCircuit(resistors);
		System.out.println("row: " + rc1.getTotalValue() + " - #Resistors: " + rc1.getNumberOfResistors());

		ParallelCircuit pc1 = new ParallelCircuit(resistors);
		System.out.println("parallel: " + pc1.getTotalValue() + " - #Resistors: " + pc1.getNumberOfResistors());

	}

}
