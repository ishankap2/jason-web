package initagent;

public class WrongLocationStack {
	
	public static String[] stackArray = {
//			"6.794968,79.900738","6.794992,79.900682",
//			"6.795015,79.900631","6.795033,79.900579",
//			"6.795054,79.900531","6.795072,79.900486",
//			"6.795078,79.900468","6.795092,79.900434",
//			"6.795105,79.900402","6.795119,79.900366",
//			"6.795134,79.900324","6.795153,79.900290",
//			"6.795169,79.900249","6.795183,79.900210",
//			"6.795197,79.900179","6.795209,79.900143",
//			"6.795223,79.900113","6.795235,79.900080",
//			"6.795249,79.900048","6.795263,79.900010",
//			"6.795275,79.899980","6.795286,79.899945",
//			"6.795303,79.899894","6.795317,79.899856",
			"6.795311,79.899873","6.795300,79.899898","6.795284,79.899927","6.795274,79.899955",
			"6.795255, 79.899997","6.795274,79.899955"
};

private int capacity = stackArray.length;
private static int top = 0;

//public LocationStack() { // constructor
//top = -1;
//}

//public void push(String s) {
//stackArray[++top] = s;
//}

public static String pop() {
return stackArray[top++];
}

public String peek() {
return stackArray[top];
}

public static boolean isEmpty() {
return (top == stackArray.length-1);
}

}
