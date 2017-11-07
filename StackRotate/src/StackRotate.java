import java.util.Stack;

/**
 * 
 */

/**
 * @author Chris
 *
 */
public class StackRotate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
		stack.push("F");
		stack.push("G");
		stack.push("H");
		stack.push("I");
		stack.push("J");
		stack.push("K");
		stack.push("L");
		
		System.out.println(" Stack  |" + stack);
		rotate(stack, 7, 3);
		System.out.println(" Stack  |" + stack);
		System.out.println("Expected|[A, B, C, D, E, J, K, L, F, G, H, I]");
		rotate(stack, 7, 4); //rotate back to orig
		System.out.println(" Stack  |" + stack);
		System.out.println("Expected|[A, B, C, D, E, F, G, H, I, J, K, L]");
		

	}
	
	public static void rotate(Stack<String> stk, int n, int m){
		if((n<=0 || m<=0) || (n <= m) || stk.isEmpty() || (stk.size() < n)){
			throw new IllegalArgumentException();
		}
		System.out.printf("\nRotating elements (N=%d, M=%d)...\n", n, m);
		
		Stack<String> tmpKeep = new Stack<>();
		Stack<String> tmpMove = new Stack<>();
		
		for(int i = 1; i <= n; i++){
			if(i <= m){
				tmpMove.push(stk.pop());
			}else{
				tmpKeep.push(stk.pop());
			}
		}
		
		while(!tmpMove.isEmpty()){
			stk.push(tmpMove.pop());
		}
		
		while(!tmpKeep.isEmpty()){
			stk.push(tmpKeep.pop());
		}
	}

}
