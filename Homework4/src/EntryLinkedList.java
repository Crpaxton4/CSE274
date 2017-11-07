import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Chris
 *
 */
public class EntryLinkedList<T> extends AbstractEntryLinkedList<T>{

	@Override
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);

		if (isEmpty())
			firstNode = newNode;
		else {
			Node lastNode = super.getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode);
		}

		numberOfEntries++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
