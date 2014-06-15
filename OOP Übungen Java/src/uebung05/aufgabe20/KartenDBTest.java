package uebung05.aufgabe20;

public class KartenDBTest {

	public static void main(String[] args) {

		int ticketAmount = 100;
		int noOfVVK = 5;

		KartenDB kartenDB = new KartenDB(ticketAmount);

		Vorverkaufsstelle[] vvks = new Vorverkaufsstelle[noOfVVK];
		for (int i = 0; i < vvks.length; i++) {
			vvks[i] = new Vorverkaufsstelle(kartenDB, "VVK " + (i + 1));
		}

		for (int i = 0; i < vvks.length; i++) {
			vvks[i].start();
		}
	}

}
