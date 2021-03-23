package list.stackqueue;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1 - Good Theory");
        stack.push("2 - Verum Rex");
        stack.push("3 - Kairiiii");
        stack.push("4 - Plot relevant");

        System.out.println("Peek next one: " + stack.peek());
        System.out.println("Search for 3 - Kairiiii: " + stack.search("3 - Kairiiii"));
        System.out.println("5 - Ah: " + stack.search("5 - Ah"));
        System.out.println();

        while(!stack.isEmpty()){
            System.out.println("Deleting - " + stack.pop());
        }
    }
}
