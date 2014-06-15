package uebung05.aufgabe20;

public class KartenDB {

	private int initialAmount;
	private int amount;

	public KartenDB(int amount) {
		this.amount = amount;
		this.initialAmount = amount;
	}

	public synchronized int reserve() {
		if (amount > 0) {
			amount--;
			return initialAmount - amount;
		}
		return -1;
	}

}
