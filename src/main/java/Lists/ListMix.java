
package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListMix {
      public static void main(String[] args){
            List<String> listOne = new ArrayList<String>();
            listOne.add("A: ");
            listOne.add("B: ");
            listOne.add("C: ");
            listOne.add("D: ");
            List<String> listTwo = new ArrayList<String>();
            listTwo.add("1");
            listTwo.add("2");
            listTwo.add("3");
            listTwo.add("4");
            List<String> newList = Stream.concat(listOne.stream(), listTwo.stream())
                             .collect(Collectors.toList());
            
            for(int a = 0; a<newList.size();a++){
                  System.out.println(newList.get(a));
            }
      }
}
