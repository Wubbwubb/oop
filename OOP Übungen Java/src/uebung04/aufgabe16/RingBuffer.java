package uebung04.aufgabe16;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RingBuffer<E> implements Collection<E> {

	private int size;
	private int capacity;
	private int nextIndex;
	private int firstIndex;

	private List<E> list;

	public RingBuffer(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.nextIndex = 0;
		this.firstIndex = 0;
		list = new ArrayList<>(capacity);
	}

	public int getLastIndex() {
		int index = (nextIndex - 1) % capacity;
		if (nextIndex - 1 < 0) {
			index += capacity;
		}
		return index;
	}

	public int getCapacity() {
		return capacity;
	}

	public E get(int index) {
		if (index >= size || index < 0) {
			throw new IllegalArgumentException("illegal index");
		}
		return list.get(index);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = firstIndex; i < firstIndex + size; i++) {
			if (list.get(i % capacity).equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		int i = 0;
		for (int index = firstIndex; index < firstIndex + size; index++) {
			arr[i++] = list.get(index % capacity);
		}
		return arr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
		}

		int i = 0;
		Object[] result = a;
		for (int index = firstIndex; index < firstIndex + size; index++) {
			result[i++] = list.get(index % capacity);
		}

		if (a.length > size) {
			a[size] = null;
		}

		return a;
	}

	@Override
	public boolean add(E e) {
		if (size == capacity) {
			list.set(nextIndex, e);
		} else {
			list.add(nextIndex, e);
		}
		nextIndex = (nextIndex + 1) % capacity;
		if (size == capacity) {
			firstIndex = nextIndex;
		}
		size = Math.min(capacity, size + 1);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object object : c) {
			if (!contains(object)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void clear() {
		size = 0;
		nextIndex = 0;
		firstIndex = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new RingBufferIterator<>(this);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

}
