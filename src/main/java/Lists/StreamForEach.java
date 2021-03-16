package Lists;

import java.util.ArrayList;

public class StreamForEach {

      static String text = "J";
      static ArrayList<String> list = new ArrayList<String>();

      public static void main(String[] args) {
            //DefaultListModel filteredItems = new DefaultListModel();
            list.add("Danny (Game Grumps)");
            list.add("Arin (Game Grumps)");
            list.add("Jared (TheGamersJoint)");
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            ArrayList stars = list;
            stars.stream().forEach((star) -> {
                  String starName = star.toString().toLowerCase();
                  if (starName.contains(text.toLowerCase())) {
                        System.out.println("TEST N1: "+star);
                  }
            }
            );
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            ArrayList<String> list2 = list;
            for(int a=0;a<list2.size();a++){
                  if(list2.get(a).toLowerCase().contains(text.toLowerCase())){
                        System.out.println("TEST N2: "+
                                list.get(a).substring(0, list.get(a).indexOf("(")-1));
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      }

}
