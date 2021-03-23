package list.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeMain {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("Got this!");
        deque.add("This should do it");
        deque.add("WTF is that emo");
        deque.add("Spiky hair over the top");
        deque.add("Heeeyyy");

        System.out.println("Peek: " + deque.peek());
        System.out.println("Poll: " + deque.poll());
        System.out.println("Pop: " + deque.pop());

        deque.addFirst("Smashing Cure");
    }
}
