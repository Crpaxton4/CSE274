import java.util.Stack;

/**
 * 
 */

/**
 * @author paxtoncr
 *
 */
public class StackDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayStack<String> arrayStack = new ArrayStack<String>();
		LinkedStack<String> linkedStack = new LinkedStack<String>();
		VectorStack<String> vectorStack = new VectorStack<String>();
		
		System.out.println("ARRAY STACK");
		arrayStack.push("A");
		arrayStack.push("B");
		arrayStack.push("C");
		arrayStack.pop();
		arrayStack.pop();
		arrayStack.push("C");
		arrayStack.push("C");
		arrayStack.push("C");
		arrayStack.push("B");
		arrayStack.push("B");
		arrayStack.pop();
		
		System.out.println("LINKED STACK");
		linkedStack.push("A");
		linkedStack.push("B");
		linkedStack.push("C");
		linkedStack.push("C");
		linkedStack.pop();
		linkedStack.pop();
		linkedStack.push("C");
		linkedStack.push("C");
		linkedStack.pop();
		
		System.out.println("VECTOR STACK");
		vectorStack.push("A");
		vectorStack.push("C");
		vectorStack.pop();
		vectorStack.pop();
		vectorStack.push("C");
		vectorStack.push("C");
		vectorStack.push("B");
		vectorStack.push("C");
		vectorStack.pop();
		vectorStack.push("C");
		vectorStack.push("B");
		
		String expectedArray = "ACCCB";
		String expectedVector = "CCBCB";
		String expectedLinked = "ABC";
		
		displayStack(arrayStack, expectedArray);
		displayStack(vectorStack, expectedVector);
		displayStack(linkedStack, expectedLinked);

	}
	
	public static void displayStack(StackInterface<String> stk, String expected){
		System.out.println("Expected|" + expected);
		String output = stk.getClass().getName()+"|";
		Stack<String> tmp = new  Stack<>();
		
		while(!stk.isEmpty()){
			tmp.push(stk.pop());
		}
		
		while(!tmp.isEmpty()){
			String s = tmp.pop();
			output += s;
			stk.push(s);
		}
		
		System.out.println(output + "\n");
	}

}
