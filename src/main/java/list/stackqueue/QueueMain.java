package list.stackqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        //first-in-first-out, Can us a Comparable to
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("1. Ava is namine");
        queue.offer("2. Roxas is Ven");
        queue.offer("3. Inside of Kairi");
        queue.offer("4. This is Nomura's");
        queue.offer("5. Let's do this!");

        while(!queue.isEmpty()){
            System.out.println("Deleting: " + queue.poll());
        }
            
        
    }
}
