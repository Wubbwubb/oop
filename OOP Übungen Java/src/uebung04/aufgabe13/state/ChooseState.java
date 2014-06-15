package uebung04.aufgabe13.state;

import java.util.NoSuchElementException;
import java.util.Scanner;

import uebung04.aufgabe13.Automat;
import uebung04.aufgabe13.product.Product;

public class ChooseState implements AutomatState {

	@Override
	public void process(Automat automat) {

		System.out.println("Produkt ausw\u00e4hlen");

		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		scanner.close();

		try {
			int id = Integer.parseInt(s);
			Product p = automat.getProduct(id);
			if (p == null) {
				automat.setState(new SoldOutState());
			} else {
				if (automat.getMoney() >= p.getPrice()) {
					automat.setState(new GiveOutState(p));
				} else {
					automat.setState(new TooLessMoneyState());
				}
			}
		} catch (NoSuchElementException e) {
			automat.setState(new NoSuchProductState());
		} catch (Exception e) {
			System.out.println("ung\u00fcltige Eingabe");
			automat.setState(new StartState());
		}

	}

}
