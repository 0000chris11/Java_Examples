package Array_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Array_DeleteDup_ABC {

      private static ArrayList<String> list = new ArrayList<String>();

      public static void main(String[] args) {
            list.add("AVA");
            list.add("BUSXCUME");
            list.add("CLESS");
            list.add("AVA");
            list.add("DDD");
            list.add("BONK");

            for (int c = 0; c < list.size(); c++) {
                  System.out.println(list.get(c));
            }
            //------------------------------------------------------------------------------------
            Set<String> set = new LinkedHashSet<>(list);

            list.clear();

            list = new ArrayList<String>(set);
            Collections.sort(list);
            //------------------------------------------------------------------------------------
            for (int c = 0; c < list.size(); c++) {
                  System.out.println(list.get(c));
            }
      }

}
