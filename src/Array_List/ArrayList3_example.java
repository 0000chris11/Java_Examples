package Array_List;

import java.util.*;

public class ArrayList3_example {

      public static void main(String[] args) {
            String[] stuff = {"Shadow", "Darkess", "Light", "Hope"};
            LinkedList<String> list = new LinkedList<String>(Arrays.asList(stuff));
            //List<String> list2 = Arrays.asList(stuff); -- this for only list
            //asList: converts an array to a list

            list.add("Sacred");//LinkedList methods
            list.addFirst("Despair");

            Collections.sort(list);//For List and LinkedList
            System.out.printf("ABC: %s\n", list); //you can print all the elements with this line
            //only in a list(no array)
            Collections.sort(list, Collections.reverseOrder());
            //Collections.reverse(list); -- this way too
            System.out.printf("ZYX: %s\n ", list);
            //--COPY-ARRAY/LIST---------------------------------------------------
            String[] newstuff = new String[stuff.length];
            List<String> copyList = Arrays.asList(stuff);
            Collections.copy(copyList, list);
            Collections.fill(copyList, "X");//Replace al the elements whit the 2nd parameter
            //now copyList has the same elements that list
            //--------------------------------------------------------------------
            stuff = list.toArray(new String[list.size()]);
            //toArray: converts the list back to an array by giving it the size of the list

            for (String x : stuff) {
                  System.out.printf("%s ", x);
            }
      }
}
