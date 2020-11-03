package Array_List;

import java.util.*;

public class HashSet_e {

      public static void main(String[] args) {
            String[] s = {"1 Slap", "2 Hop", "3 Wonder", "4 Petals", "2 Hop", "1 Slap", "5 Today"};
            List<String> list = new ArrayList<>(Arrays.asList(s));
            List<String> list_old = Arrays.asList(s);
            System.out.println("Printing List: " + list);
            Set<String> set = new HashSet<String>(list);
            list.clear();
            //it takes away the duplicated elements on the list
            System.out.println("Printing Set: " + set);
            
            list.addAll(set);
            System.out.println("Printing List After Set: " + list);

      }

      public static int getIndex(Set<? extends Object> set, Object value) {
            int result = 0;
            for (Object entry : set) {
                  if (entry.equals(value)) {
                        return result;
                  }
                  result++;
            }
            return -1;
      }
}
