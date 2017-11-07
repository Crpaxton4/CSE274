import java.util.Arrays;import java.util.EmptyStackException;/** * A class of stacks whose entries are stored in an array. *  * @author Frank M. Carrano and Timothy M. Henry * @version 4.0 */public class ArrayStack<T> implements StackInterface<T> {	private T[] stack; // Array of stack entries	private int topIndex; // Index of top entry	private boolean initialized = false;	private static final int DEFAULT_CAPACITY = 50;	private static final int MAX_CAPACITY = 10000;	public ArrayStack() {		this(DEFAULT_CAPACITY);	} // end default constructor	public ArrayStack(int initialCapacity) {		checkCapacity(initialCapacity);		// The cast is safe because the new array contains null entries		@SuppressWarnings("unchecked")		T[] tempStack = (T[]) new Object[initialCapacity];		stack = tempStack;		topIndex = -1;		initialized = true;	} // end constructor	// The following are non-working stubs	private void checkCapacity(int d) {		// ignore	}	public void clear() {		while (!isEmpty()) {			pop();		}	}	public boolean isEmpty() {		return topIndex == -1;	}	public T peek() {		if (isEmpty())			throw new EmptyStackException();		return stack[topIndex];	}	public void push(T newEntry) {		if (topIndex < stack.length) {			topIndex++;			stack[topIndex] = newEntry;		}	}	public T pop() {		if (isEmpty())			throw new EmptyStackException();		T tmp = stack[topIndex];		stack[topIndex] = null;		topIndex--;		return tmp;	}} // end ArrayStack