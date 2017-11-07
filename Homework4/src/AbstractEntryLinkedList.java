import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class AbstractEntryLinkedList<T> implements List<T> {
	
	// Making intentional use of the default access modifier (also in node class)  
	int numberOfEntries = 0;
	Node firstNode;
	
	public AbstractEntryLinkedList() {
		clear();
	}
	
	@Override
	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		try {
			anEntry = (T) anEntry;
		} catch (ClassCastException e) {
			return false;
		}

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}

		return found;
	}

	@Override
	public int indexOf(Object anEntry) {
		int count = 0;
		Node curr = firstNode;
		boolean found = false;

		while (curr != null && !found) {
			if (curr.data.equals(anEntry)) {
				found = true;
			} else {
				curr = curr.next;
				count++;
			}
		}

		if (curr == null) {
			return -1;
		} else {
			return count;
		}
	}
	
	@Override
	public int size() {
		return numberOfEntries;
	}
	
	@Override
	public Object[] toArray() {
		Object[] result = new Object[numberOfEntries];

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}

		return result;
	}
	
	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();

			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}
	
	private Node getNodeAt(int givenPosition) {
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;

		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();

		assert currentNode != null;

		return currentNode;
	}
	


	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * Inner Class
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	class Node { 
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}

		T getData() {
			return data;
		}

		void setData(T newData) {
			data = newData;
		}

		Node getNextNode() {
			return next;
		}

		void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 'Unimplemented' List<T> Methods
	 * 
	 * 
	 * Used to separate these methods out of the concrete class to make it
	 * more readable
	 * 
	 * 
	 */

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public T set(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}
}
