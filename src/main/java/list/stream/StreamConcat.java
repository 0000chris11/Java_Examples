
package list.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import basic_reusable_classes.ArrayData;

class StreamConcat {

      private StreamConcat(){
            ArrayData data = ArrayData.getInstance();
            List<String> listOne = new ArrayList<>(Arrays.asList(data.getArrayRandomString()));
            List<String> listTwo = new ArrayList<>(Arrays.asList(data.getArrayStringNumber()));
 
            List<String> newList = Stream.concat(listOne.stream(), listTwo.stream())
                             .collect(Collectors.toList());
            
            for(int a = 0; a<newList.size();a++){
                  System.out.println(newList.get(a));
            }
      }

      public static void main(String[] args){
            new StreamConcat();
      }
}
