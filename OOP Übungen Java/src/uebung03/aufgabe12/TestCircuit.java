package uebung03.aufgabe12;

import java.util.Collection;
import java.util.LinkedList;

public class TestCircuit {

	public static void main(String[] args) {

		Resistor r1 = new Resistor(2.0);
		Resistor r2 = new Resistor(4.0);

		Collection<ICircuit> circuits1 = new LinkedList<>();
		circuits1.add(r1);
		circuits1.add(r2);

		RowCircuit rc1 = new RowCircuit(circuits1);
		System.out.println("row: " + rc1.getTotalValue() + " - #Resistors: " + rc1.getNumberOfResistors());

		ParallelCircuit pc1 = new ParallelCircuit(circuits1);
		System.out.println("parallel: " + pc1.getTotalValue() + " - #Resistors: " + pc1.getNumberOfResistors());

		Collection<ICircuit> circuits2 = new LinkedList<>();
		circuits2.add(rc1);
		circuits2.add(pc1);

		RowCircuit rc2 = new RowCircuit(circuits2);
		System.out.println("parallel: " + rc2.getTotalValue() + " - #Resistors: " + rc2.getNumberOfResistors());

	}

}
