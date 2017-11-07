import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 */

/**
 * @author Chris
 *
 */
public class Stack274<T> implements StackInterface<T> {

	private int topIndex;
	private final static int MIN_ARRAY_SIZE = 20;
	private T[] elements;

	/**
	 * 
	 */
	public Stack274() {
		this(MIN_ARRAY_SIZE);
	}

	/**
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public Stack274(int capacity) {
		if (capacity > MIN_ARRAY_SIZE) {
			elements = (T[]) new Object[capacity]; // Didn't like it when I
													// tried to just make a T[]
		} else {
			elements = (T[]) new Object[MIN_ARRAY_SIZE];
		}
		
		topIndex = getCapacity();
	}

	/**
	 * @return
	 */
	private boolean isFull() {
		return topIndex <= 0;
	}

	/**
	 * @return
	 */
	public int getCapacity() {
		return elements.length;
	}

	/**
	 * @return
	 */
	public int currentSize() {
		return getCapacity() - topIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see StackInterface#push(java.lang.Object)
	 */
	@Override
	public void push(T newEntry) {
		if (isFull()) expandArray();

		topIndex--;
		elements[topIndex] = newEntry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see StackInterface#pop()
	 */
	@Override
	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();

		T result = elements[topIndex];
		elements[topIndex] = null;
		topIndex++;

		if ((currentSize() < getCapacity() / 2) && (getCapacity() / 2 >= 20)) condenseArray();

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see StackInterface#peek()
	 */
	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return elements[topIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see StackInterface#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return topIndex == getCapacity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see StackInterface#clear()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		elements = (T[]) new Object[MIN_ARRAY_SIZE];
		topIndex = getCapacity();
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void expandArray() {
		System.out.println("\nExpanding stack...");
		
		T[] expanded = (T[]) new Object[elements.length*2];

		for (int i = topIndex; i < getCapacity(); i++) {
			int index = (expanded.length - i) - 1;
			expanded[index] = elements[i];
		}
		topIndex = expanded.length - elements.length;
		elements = expanded;
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void condenseArray() {
		System.out.println("Condensing Stack...");
		T[] condensed = (T[]) new Object[elements.length / 2];

		for (int i = topIndex; i < elements.length; i++) {
			int index = i - condensed.length;
			condensed[index] = elements[i];
		}

		topIndex -= condensed.length;
		elements = condensed;
	}
	
	@Override
	public String toString() {
		return "\nStack274| " + Arrays.toString(elements) ;
	}

	public static  void main(String[] args){
		Stack274<Integer> stack = new Stack274<>();
		System.out.println(stack);
		System.out.println("Aray Capacity: " + stack.getCapacity());
		System.out.println("  Stack Size : " + stack.currentSize());
		
		for(int i = 0; i < 20; i++){
			stack.push(i);
		}		
		
		System.out.println(stack);
		System.out.println("Aray Capacity: " + stack.getCapacity());
		System.out.println("  Stack Size : " + stack.currentSize());
		
		stack.push(30);
		System.out.println(stack);
		System.out.println("Aray Capacity: " + stack.getCapacity());
		System.out.println("  Stack Size : " + stack.currentSize());
		
		for(int i = 0; i < 20; i++){
			stack.push(i);
		}	
		
		System.out.println(stack);
		System.out.println("Aray Capacity: " + stack.getCapacity());
		System.out.println("  Stack Size : " + stack.currentSize());
		
		stack.pop();
		stack.pop();
		
		System.out.println(stack);
		System.out.println("Aray Capacity: " + stack.getCapacity());
		System.out.println("  Stack Size : " + stack.currentSize());
		
		for(int i = 0; i < 25; i++){
			stack.pop();
		}
		
		System.out.println(stack);
		System.out.println("Aray Capacity: " + stack.getCapacity());
		System.out.println("  Stack Size : " + stack.currentSize());
		
		
		for(int i = 0; i < 10; i++){
			stack.pop();
		}
		
		System.out.println(stack);
		System.out.println("Aray Capacity: " + stack.getCapacity());
		System.out.println("  Stack Size : " + stack.currentSize());
		
		stack.clear();
		System.out.println(stack);
		System.out.println("Aray Capacity: " + stack.getCapacity());
		System.out.println("  Stack Size : " + stack.currentSize());
		
		stack.push(0);
		System.out.println(stack);
		System.out.println("Aray Capacity: " + stack.getCapacity());
		System.out.println("  Stack Size : " + stack.currentSize());
		
		

	}

}
