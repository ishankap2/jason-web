package initagent;

public class InputStack {

	public static String[] stackArray = {};
	private int capacity = stackArray.length;
	private static int top = 0;

	public static String pop() {
		return stackArray[top++];
	}

	public String peek() {
		return stackArray[top];
	}

	public static boolean isEmpty() {
		return (top == stackArray.length - 1);
	}

}
