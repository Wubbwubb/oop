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

		SeriesCircuit rc1 = new SeriesCircuit(circuits1);
		System.out.println("row: " + rc1.getResistance() + " - #Resistors: " + rc1.getNumberOfResistors());

		ParallelCircuit pc1 = new ParallelCircuit(circuits1);
		System.out.println("parallel: " + pc1.getResistance() + " - #Resistors: " + pc1.getNumberOfResistors());

		Collection<ICircuit> circuits2 = new LinkedList<>();
		circuits2.add(rc1);
		circuits2.add(pc1);

		SeriesCircuit rc2 = new SeriesCircuit(circuits2);
		System.out.println("parallel: " + rc2.getResistance() + " - #Resistors: " + rc2.getNumberOfResistors());

	}

}
