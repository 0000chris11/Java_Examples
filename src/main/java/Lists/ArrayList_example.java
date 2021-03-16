package Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayList_example {

      public static void main(String[] args) {
            //list allows you to add duplicate elements
            String[] things = {"Claude", "Rena", "Ashton", "Leon"};
            List<String> list1 = new ArrayList<String>();
            //Adding elements from the list o an arrayList
            for (String x : things) {
                  list1.add(x);
            }
            String[] otherthings = {"Ashton", "Leon"};
            List<String> list2 = new ArrayList<String>();

            for (String y : otherthings) {
                  list2.add(y);
            }
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            for (int i = 0; i < list1.size(); i++) {
                  //System.out.println(list1.get(i));
                  System.out.printf("%s ", list1.get(i));
            }
            System.out.println("\n");
            
            editList(list1, list2);
            for (int i = 0; i < list1.size(); i++) {
                  System.out.println(list1.get(i));
            }
      }//------------------------(Collection<String>.............)

      private static void editList(List<String> l1, List<String> l2) {
            Iterator<String> it = l1.iterator();
            //hasNext, next, remove are methods from the iterator
            while (it.hasNext()) {//while it has item on it
                  if (l2.contains(it.next()))//if list2 contains the same item in the iterator
                  {
                        it.remove();//deleted
                  }
            }
      }

}
