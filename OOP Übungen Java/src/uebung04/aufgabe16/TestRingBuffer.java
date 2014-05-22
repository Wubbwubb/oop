package uebung04.aufgabe16;

import java.util.Iterator;

public class TestRingBuffer {

	public static void main(String[] args) {

		RingBuffer<Integer> buff = new RingBuffer<>(5);

		for (int i = 0; i < 7; i++) {
			buff.add(i);
			for (int j = 0; j < buff.size(); j++) {
				System.out.print(buff.get(j) + ", ");
			}
			System.out.println();
		}

		Iterator<Integer> iter = buff.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		Object[] arr = buff.toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
