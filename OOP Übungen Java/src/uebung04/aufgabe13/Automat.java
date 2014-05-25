package uebung04.aufgabe13;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import uebung04.aufgabe13.product.Product;
import uebung04.aufgabe13.state.AutomatState;
import uebung04.aufgabe13.state.StartState;

public class Automat {

	private AutomatState state;
	private Map<Integer, List<Product>> products;
	private double money;

	public Automat(Map<Integer, List<Product>> pProducts) {
		state = new StartState();
		setProducts(pProducts);
		setMoney(0.0);
	}

	public AutomatState getState() {
		return state;
	}

	public void setState(AutomatState state) {
		this.state = state;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void addMoney(double money) {
		setMoney(getMoney() + money);
	}

	public void resetMoney() {
		setMoney(0.0);
	}

	public void run() {
		while (true) {
			process();
		}
	}

	private void process() {
		state.process(this);
	}

	public Map<Integer, List<Product>> getProducts() {
		return products;
	}

	private void setProducts(Map<Integer, List<Product>> products) {
		this.products = products;
	}

	public Product getProduct(Integer key) throws NoSuchElementException {
		List<Product> p = products.get(key);
		if (p == null) {
			throw new NoSuchElementException();
		}
		if (!p.isEmpty()) {
			return p.remove(0);
		}
		return null;
	}

	@Override
	public String toString() {
		String s = "";
		for (Entry<Integer, List<Product>> entry : getProducts().entrySet()) {
			s += entry.getKey() + " - ";
			if (entry.getValue().isEmpty()) {
				s += "ausverkauft";
			} else {
				for (Product p : entry.getValue()) {
					s += p.toString();
					break;
				}
				s += " (x" + entry.getValue().size() + ")";
			}
			s += "\n";
		}
		s += getMoney() + "€\n";
		return s;
	}

}
