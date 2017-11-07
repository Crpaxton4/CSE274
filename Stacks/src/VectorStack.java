import java.util.EmptyStackException;import java.util.Vector;/** * A class of stacks whose entries are stored in a vector. *  * @author Frank M. Carrano and Timothy M. Henry * @version 4.0 */public class VectorStack<T> implements StackInterface<T> {	private Vector<T> stack; // Last element is the top entry in stack	private boolean initialized = false;	private static final int DEFAULT_CAPACITY = 50;	private static final int MAX_CAPACITY = 10000;	public VectorStack() {		this(DEFAULT_CAPACITY);	} // end default constructor	public VectorStack(int initialCapacity) {		checkCapacity(initialCapacity);		stack = new Vector<>(initialCapacity); // Size doubles as needed		initialized = true;	} // end constructor	// The following are non-working stubs	 private void checkCapacity(int d) {  	 }	 public void clear() {		 stack.clear();	 }	 public boolean isEmpty() {		 return stack.size() == 0;	 }	 public T peek() {		 if(stack.size() == 0) throw new EmptyStackException();		 return stack.get(stack.size()-1);	 }	 public void push(T newEntry) {		 stack.add(0, newEntry);	 }	 public T pop() {		 if(stack.size() == 0) throw new EmptyStackException();		 return stack.remove(0);	 }} // end VectorStack