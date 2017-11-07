import java.util.*;

/**
 * 
 */

/**
 * @author Chris Paxton
 * @param <T>
 *
 */
public class TwoPartCircularDoublyLinkedDeque<T> implements DequeInterface<T>, Iterable<T> {

	DLNode frontNode;
	DLNode backNode;
	DLNode frontFreeNode;
	DLNode backFreeNode;
	private int numEntries;

	public TwoPartCircularDoublyLinkedDeque() {
		DLNode start = new DLNode(null, null, null);
		start.setNextNode(start);
		start.setPreviousNode(start);
		frontNode = backNode = frontFreeNode = backFreeNode = start;
		numEntries = 0;

	}

	@Override
	public void addToFront(T newEntry) {
		if (frontFreeNode == backFreeNode) {
			if (getCapacity() == 1) {
				addFirstNode(newEntry);
			} else {
				DLNode entry = new DLNode(frontNode, newEntry, frontFreeNode);
				frontNode.setNextNode(entry);
				frontFreeNode.setPreviousNode(entry);
				frontNode = entry;
				numEntries++;

			}
			
		}else if(size() == 0){
			frontNode.setData(newEntry);
			numEntries++;
		} else {
			frontFreeNode = frontFreeNode.getNextNode();
			frontNode = frontNode.getNextNode();;
			frontNode.setData(newEntry);
			numEntries++;
		}

	}

	@Override
	public void addToBack(T newEntry) {
		if (frontFreeNode == backFreeNode) {
			if (getCapacity() == 1) {
				addFirstNode(newEntry);
			} else {
				DLNode entry = new DLNode(backFreeNode, newEntry, backNode);
				backFreeNode.setNextNode(entry);
				backNode.setPreviousNode(entry);
				backNode = entry;
				numEntries++;
			}

		}else if(size() == 0){
			backNode.setData(newEntry);
			numEntries++;
		} else {
			backFreeNode = backFreeNode.getPreviousNode();
			backNode = backNode.getPreviousNode();
			backNode.setData(newEntry);
			numEntries++;
		}
	}
	
	private void addFirstNode(T newEntry){
		DLNode entry = new DLNode(frontFreeNode, newEntry, backNode);
		frontNode = backNode = entry;
		frontFreeNode.setPreviousNode(frontNode);
		backFreeNode.setNextNode(backNode);
		numEntries++;
	}

	@Override
	public T removeFront() {
		T result = null;
		if (isEmpty()) {
			throw new EmptyQueueException();
		} else if (size() == 1) {
			result = frontNode.getData();
			clear();
		} else {
			result = frontNode.getData();
			frontNode.setData(null);
			frontNode = frontNode.getPreviousNode();
			frontFreeNode = frontFreeNode.getPreviousNode();
			numEntries--;
		}

		return result;
	}

	@Override
	public T removeBack() {
		T result = null;
		if (isEmpty()) {
			throw new EmptyQueueException();
		} else if (size() == 1) {
			result = backNode.getData();
			clear();
		} else {
			result = backNode.getData();
			backNode.setData(null);
			backNode = backNode.getNextNode();
			backFreeNode = backFreeNode.getNextNode();
			numEntries--;
		}

		return result;
	}

	@Override
	public T getFront() {
		if (isEmpty())
			throw new EmptyQueueException();

		return frontNode.getData();
	}

	@Override
	public T getBack() {
		if (isEmpty())
			throw new EmptyQueueException();

		return backNode.getData();
	}

	@Override
	public boolean isEmpty() {// done
		return size() == 0;
	}

	@Override
	public void clear() {// done
		DLNode curr = frontNode;
		while (curr != backFreeNode) {
			curr.setData(null);
			curr = curr.getNextNode();
		}

		frontNode = backNode = curr;
		frontFreeNode = curr.getNextNode();
		backFreeNode = curr.getPreviousNode();
		numEntries = 0;

	}

	@Override
	public int size() {// Done
		return numEntries;
	}

	public int getCapacity() {// Done
		int count = 1;
		DLNode curr = frontFreeNode;
		while (curr.getNextNode() != frontFreeNode) {
			count++;
			curr = curr.getNextNode();
		}

		return count;
	}

	@Override
	public Iterator<T> iterator() {
		return new ForewardsIterator();
	}

	public Iterator<T> revIterator() {
		// TODO Auto-generated method stub
		return new ReverseIterator();
	}

	@Override
	public String toString() {
		String result = "TwoPartCircularDoublyLinkedDeque Front| ";
		DLNode curr = frontNode;
		while (curr != backFreeNode) {
			result += curr.getData() + " ";
			curr = curr.getPreviousNode();
		}

		return result + "|Back";
	}

	/*=========================================================================*/

	/**
	 * Node class from LinkedDeque.java
	 *
	 */
	private class DLNode {
		private T data;
		private DLNode next;
		private DLNode previous;

		private DLNode(T dataPortion) {
			data = dataPortion;
			next = null;
			previous = null;
		}

		private DLNode(DLNode previousNode, T dataPortion, DLNode nextNode) {
			data = dataPortion;
			next = nextNode;
			previous = previousNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private DLNode getNextNode() {
			return next;
		}

		private void setNextNode(DLNode nextNode) {
			next = nextNode;
		}

		private DLNode getPreviousNode() {
			return previous;
		}

		private void setPreviousNode(DLNode previousNode) {
			previous = previousNode;
		}
	}

	private class ForewardsIterator implements Iterator<T> {
		private DLNode nextNode;

		private ForewardsIterator() {
			nextNode = frontNode;
		}

		@Override
		public boolean hasNext() {
			return nextNode != backFreeNode;
		}

		@Override
		public T next() {
			T result = null;
			if (hasNext()) {
				result = (T) nextNode.data;
				nextNode = nextNode.previous;

			} else {
				throw new NoSuchElementException();
			}
			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove operation not supported by this Iterator");
		}

	}

	private class ReverseIterator implements Iterator<T> {
		private DLNode nextNode;

		private ReverseIterator() {
			nextNode = backNode;
		}

		@Override
		public boolean hasNext() {
			return nextNode != frontFreeNode;
		}

		@Override
		public T next() {
			T result = null;
			if (hasNext()) {
				result = (T) nextNode.data;
				nextNode = nextNode.next;

			} else {
				throw new NoSuchElementException();
			}
			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove operation not supported by this Iterator");
		}

	}

}
