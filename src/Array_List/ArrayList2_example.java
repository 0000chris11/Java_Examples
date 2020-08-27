package Array_List;

import java.util.*;

public class ArrayList2_example {

      public static void main(String[] args) {
            String[] things1 = {"Finn", "Steven", "Star", "Blossom", "Twilight", "delete_me"};
            List<String> list1 = new LinkedList<String>();
            for (String x : things1) {
                  list1.add(x);
            }
            String[] things2 = {"Sora", "Frisk", "delete_me", "Usagi"};
            List<String> list2 = new LinkedList<String>();
            for (String y : things2) {
                  list2.add(y);
            }
            list1.addAll(list2);
            list2 = null;

            printMe(list1);
            removeStuff(list1, 5, 9);
            printMe(list1);
            reverseMe(list1);
      }

      private static void printMe(List<String> l) {
            for (String a : l) {
                  System.out.printf("%s ", a);
            }
            System.out.println();
      }

      private static void removeStuff(List<String> l, int from, int to) {
            l.subList(from, to).clear();//takes a portion of the list and the deletes it
      }

      private static void reverseMe(List<String> l) {
            ListIterator<String> li = l.listIterator(l.size());
            //listiterator allow you to traverse your list in either direction
            //it lets you use hasPrevious and previous methods
            while (li.hasPrevious()) {
                  System.out.printf("%s ", li.previous());
            }
            System.out.println();
      }
}
