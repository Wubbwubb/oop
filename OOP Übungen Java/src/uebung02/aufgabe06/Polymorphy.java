package uebung02.aufgabe06;

import java.util.LinkedList;
import java.util.List;

public class Polymorphy {

	public static void main(String[] args) {

		// ####################
		// ###### ad hoc ######
		// ####################

		// ###### �berladen ######

		// + Operator wird f�r Klasse String als Konkatenation �berladen
		String string1 = "Hallo" + " " + "Welt";
		System.out.println(string1);

		// ###### Koersion ######

		// Integer n wird in String umgewandelt und konkateniert
		int n = 5;
		String string2 = "Das ist die Zahl " + n + "!";
		System.out.println(string2);

		// #######################
		// ###### universal ######
		// #######################

		// ###### parametrisch ######

		// Der Liste list d�rfen nur Objekte vom Typ Integer hinzugef�gt werden
		List<Integer> list = new LinkedList<Integer>();
		list.add(new Integer(5));

		// ###### Inklusion ######

		// Jede Klasse erbt in Java von der Klasse Object. Deshalb kann z.B. f�r diese Klasse die Methode equals(.)
		// aufgerufen werden
		Polymorphy p1 = new Polymorphy();
		Polymorphy p2 = new Polymorphy();
		System.out.println(p1.equals(p2));

	}
}
