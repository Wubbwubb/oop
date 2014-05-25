package uebung04.aufgabe13.state;

import java.util.Scanner;

import uebung04.aufgabe13.Automat;

public class MoneyInState implements AutomatState {

	@Override
	public void process(Automat automat) {
		System.out.println("gew\u00fcnschten Betrag eingeben");

		String s = new Scanner(System.in).next();

		try {
			double money = Double.parseDouble(s);
			if (money > 0.0) {
				automat.addMoney(money);
			}
		} catch (Exception e) {
			System.out.println("ung\u00fcltige Eingabe");
		} finally {
			automat.setState(new StartState());
			System.out.println(automat.getMoney() + "€ im Automat");
		}
	}

}
