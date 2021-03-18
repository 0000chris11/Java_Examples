package Array_List;

import java.util.*;

public class ArrayList4_Compare {

      public static void main(String[] args) {
            String[] ch = {"a", "b", "c"};
            String[] st1 = {"a", "b", "c"};
            String[] st2 = {"aaa", "bbb", "ccc"};
            String[] st3 = {"1", "2"};
            List<String> list = Arrays.asList(ch);
            List<String> list1 = new ArrayList<String>(Arrays.asList(st1));
            //LinkedList<String> list2 = Arrays.asList(st); ---NOT THIS WAY
            LinkedList<String> list2 = new LinkedList<String>(Arrays.asList(st2));
            ArrayList<String> list3 = new ArrayList<String>(Arrays.asList(st3));

            list2.addAll(list);//2to3, 3to2, 2to1, 3to1 X1to...X
            list2.addFirst("---");//Only LinkedList can addFirst & addLast
            System.out.println(list2);

            Collections.addAll(list1, "d", "e", "f");
            System.out.println(list1);
            System.out.println(list2);
            System.out.println(Collections.frequency(list1, "c"));
            System.out.println(Collections.disjoint(list1, list2));
            //returns false when there are same elemnts in both lists
      }
}
