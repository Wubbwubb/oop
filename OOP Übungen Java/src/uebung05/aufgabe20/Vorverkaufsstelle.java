package uebung05.aufgabe20;

import java.util.Random;

public class Vorverkaufsstelle extends Thread {

	private static final Random random = new Random();

	private KartenDB kartenDB;
	private String name;

	public Vorverkaufsstelle(KartenDB kartenDB, String name) {
		this.kartenDB = kartenDB;
		this.name = name;
	}

	@Override
	public void run() {
		int ticketNumber = kartenDB.reserve();
		while (ticketNumber >= 0) {

			// Ausgabe
			System.out.println(name + ": Karte Nr " + ticketNumber + " reserviert");

			// Warte max. 1 Sekunde
			int millis = random.nextInt(1000) + 1;
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Versuche weitere Karte zu reservieren
			ticketNumber = kartenDB.reserve();
		}

		// Keine Karten mehr vorhanden
		System.out.println(name + " geschlossen");
	}

}
