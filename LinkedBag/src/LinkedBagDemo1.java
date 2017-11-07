/**
 * A test of the methods add, toArray, isEmpty, and getCurrentSize, as defined
 * in the first draft of the class LinkedBag.
 * 
 * @author Frank M. Carrano
 * @version 4.0
 */

/*
 * Linked Bag lab answers: 
 * 
 * 2 output: 
 * 	20 10 40 30
 * 
 * 7 answer:
 * class NewLinkedList<T> {
 * 		.
 * 		.
 * 		.
 * 	public boolean add(T anEntry){
 * 		Node newNode = new Node(anEntry, null, firstNode);
 * 		firstNode = newNode;
 * 		numberOfEntries++;
 * 		return true;
 * 	}
 * 
 * 	public boolean remove(){
 * 		if(numberOfEntries != 0){
 * 			firstNode = firstNode.next;
 * 			firstNode.prev = null;
 * 			numberOfentries--;		
 * 
 * 		}
 * 
 * 		return true;
 * 	}
 * }
 * 
 * 
 */
public class LinkedBagDemo1 {
	public static void main(String[] args) {
		System.out.println("Creating an empty bag.");
		LinkedBag1<String> aBag = new LinkedBag1<>();
		testIsEmpty(aBag, true);
		displayBag(aBag);

		String[] contentsOfBag = { "A", "D", "B", "A", "C", "A", "D" };
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);

		LinkedBag1<String> bBag = new LinkedBag1<>();
		String[] contentsOfbBag = { "A", "D", "B", "A", "C", "A", "D", "E", "D", "A", "B" };
		testAdd(bBag, contentsOfbBag);

		displayBag(aBag.intersection(bBag));
		System.out.println("^^Intersection^^\n");
		
		System.out.print("bBag equals bBag: ");
		System.out.println(bBag.equals(bBag));
		System.out.print("abag equals abag: ");
		System.out.println(aBag.equals(aBag));
		System.out.print("aBag equals bBag: ");
		System.out.println(aBag.equals(bBag));
		System.out.print("bBag equals aBag: ");
		System.out.println(bBag.equals(aBag));
		
		bBag.clear();
		displayBag(bBag);
		System.out.println("^^bBag afer clear^^");
		
		displayBag(aBag);
		System.out.println("aBag frequency of 'A': " + aBag.getFrequencyOf("A"));

		System.out.println();
		aBag.addRear("A");
		displayBag(aBag);
		System.out.println("Added another 'A'. Now ther are " + aBag.getFrequencyOf("A") + " 'A's");
		
		System.out.println("\nRemoving all 'A's...");
		aBag.removeEvery("A");
		displayBag(aBag);
		System.out.println("Now ther are " + aBag.getFrequencyOf("A") + " 'A's");

	
	} // end main

	// Tests the method isEmpty.
	// Precondition: If the bag is empty, the parameter empty should be true;
	// otherwise, it should be false.
	private static void testIsEmpty(BagInterface<String> bag, boolean empty) {
		System.out.print("\nTesting isEmpty with ");
		if (empty)
			System.out.println("an empty bag:");
		else
			System.out.println("a bag that is not empty:");

		System.out.print("isEmpty finds the bag ");
		if (empty && bag.isEmpty())
			System.out.println("empty: OK.");
		else if (empty)
			System.out.println("not empty, but it is: ERROR.");
		else if (!empty && bag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");
	} // end testIsEmpty

	// Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content) {
		System.out.print("Adding the following " + content.length + " strings to the bag: ");
		for (int index = 0; index < content.length; index++) {
			if (aBag.add(content[index]))
				System.out.print(content[index] + " ");
			else
				System.out.print("\nUnable to add " + content[index] + " to the bag.");
		} // end for
		System.out.println();

		displayBag(aBag);
	} // end testAdd

	// Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains the following string(s):");
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		} // end for

		System.out.println();
	} // end displayBag
} // end LinkedBagDemo1

/*
 * Creating an empty bag.
 * 
 * Testing isEmpty with an empty bag: isEmpty finds the bag empty: OK. The bag
 * contains the following string(s):
 * 
 * Adding the following 7 strings to the bag: A D B A C A D The bag contains the
 * following string(s): D A C A B D A
 * 
 * Testing isEmpty with a bag that is not empty: isEmpty finds the bag not
 * empty: OK.
 */
