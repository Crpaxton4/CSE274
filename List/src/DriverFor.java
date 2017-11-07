import java.util.Iterator;

/*Chris Paxton*/

/**
 * A driver that demonstrates the for-each statement with a class, such as
 * LinkedListWithIterator, that implements Iterable. Note that
 * LinkedListWithIterator implements Iterable because ListWithIteratorInterface
 * extends Iterable.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public class DriverFor {
	public static void main(String[] args) {
		ListWithIteratorInterface<Integer> integerList = new LinkedListWithIterator<>();
		integerList.add(16);
		integerList.add(4);
		integerList.add(33);
		integerList.add(27);

		for (Integer entry : integerList)
			System.out.print(entry + " ");
		System.out.println();

		ListWithIteratorInterface<String> nameList = new LinkedListWithIterator<>();
		nameList.add("Joe");
		nameList.add("Jess");
		nameList.add("Josh");
		nameList.add("Joy");

		for (String name : nameList)
			System.out.print(name + " ");
		System.out.println();

		ArrayListWithIterator<Integer> integerArrayList = new ArrayListWithIterator<>();
		for (int i = 0; i < 10; i++) {
			integerArrayList.add(i);
		}

		Iterator<Integer> iter = integerArrayList.getIterator();
		System.out.println("In order:");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();

		iter = integerArrayList.getRevIterator();
		System.out.println("Reversed:");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}

		System.out.println();

	} // end main
} // end DriverFor

/*
 * 16 4 33 27 Joe Jess Josh Joy
 */