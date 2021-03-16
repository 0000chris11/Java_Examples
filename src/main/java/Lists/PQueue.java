package Lists;

import java.util.*;

public class PQueue {

      public static void main(String[] args) {
            PriorityQueue<String> q = new PriorityQueue<String>();
            //the first one that you add takes priority in the list
            q.offer("I");
            q.offer("II");
            q.offer("III");
            q.offer("IV");
            q.offer("V");
            System.out.printf("%s " + q.peek(), q);
            System.out.println();
            q.poll();
            System.out.printf("%s " + q.peek(), q);
            System.out.println();
            q.poll();
            System.out.printf("%s " + q.peek(), q);
            System.out.println();
            q.poll();
            System.out.printf("%s " + q.peek(), q);
            System.out.println();
      }

}
