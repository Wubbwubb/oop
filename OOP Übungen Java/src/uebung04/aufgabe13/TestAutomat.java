package uebung04.aufgabe13;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import uebung04.aufgabe13.product.Candy;
import uebung04.aufgabe13.product.Drink;
import uebung04.aufgabe13.product.Product;

public class TestAutomat {

	public static void main(String[] args) {

		int noOfTwix = 10;
		int noOfMars = 8;
		int noOfWater = 15;
		int noOfCola = 6;

		List<Product> twixColl = new LinkedList<>();
		List<Product> marsColl = new LinkedList<>();
		List<Product> waterColl = new LinkedList<>();
		List<Product> colaColl = new LinkedList<>();

		for (int i = 0; i < noOfTwix; i++) {
			twixColl.add(new Candy("Twix", 0.80, 50.0));
		}

		for (int i = 0; i < noOfMars; i++) {
			marsColl.add(new Candy("Mars", 0.90, 60.0));
		}

		for (int i = 0; i < noOfWater; i++) {
			waterColl.add(new Drink("Water", 0.70, 500.0));
		}

		for (int i = 0; i < noOfCola; i++) {
			colaColl.add(new Drink("Cola", 1.00, 333.0));
		}

		Map<Integer, List<Product>> map = new HashMap<>();
		map.put(1, twixColl);
		map.put(2, marsColl);
		map.put(3, waterColl);
		map.put(4, colaColl);

		Automat a = new Automat(map);
		a.run();

	}

}
