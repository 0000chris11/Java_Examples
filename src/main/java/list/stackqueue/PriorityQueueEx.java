package list.stackqueue;

import java.util.*;

public class PriorityQueueEx {

      public static void main(String[] args) {
            //the first one that you add takes priority in the list
            PriorityQueue<String> q = new PriorityQueue<>();

            q.offer("I");
            q.offer("II");
            q.offer("III");
            q.offer("IV");
            q.offer("V");

            System.out.println(q.peek() + ": " + q);
            System.out.println("------------------------------------");
            q.poll();
            System.out.println(q.peek() + ": " + q);
            System.out.println("------------------------------------");
            q.poll();
            System.out.println(q.peek() + ": " + q);
            System.out.println("------------------------------------");
            q.poll();
            System.out.println(q.peek() + ": " + q);
            System.out.println("------------------------------------");
      }

}
