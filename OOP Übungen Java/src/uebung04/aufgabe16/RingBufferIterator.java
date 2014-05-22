package uebung04.aufgabe16;

import java.util.Iterator;

public class RingBufferIterator<E> implements Iterator<E> {

	private RingBuffer<E> ringBuffer;
	private int index;
	private int counter;

	public RingBufferIterator(RingBuffer<E> pRingBuffer) {
		this.ringBuffer = pRingBuffer;
		this.index = ringBuffer.getLastIndex();
		this.counter = 0;
	}

	@Override
	public boolean hasNext() {
		return counter != ringBuffer.size();
	}

	@Override
	public E next() {
		if (!hasNext()) {
			return null;
		}
		E el = ringBuffer.get(index);
		index = index <= 0 ? ((index - 1) % ringBuffer.getCapacity()) + ringBuffer.getCapacity() : (index - 1)
				% ringBuffer.getCapacity();
		counter++;
		return el;
	}

	@Override
	public void remove() {
	}

}
