package list.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapMain {

    public static void main(String[] args) {
        //ALLOWS NULLS AND DOES NOT ALLOWED REPITTED KEYS
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "Shaded Starlight");
        map.put(3, "For An Angel");
        map.put(2, "Born Slippy NUXX.");
        map.put(5, "The Night");
        map.put(1, "Children");
        map.put(6, null);
        map.put(null, "Face To Face");

        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            Integer key = it.next();
            System.out.println("Key: " + key);
            System.out.println("\tValue: " + map.get(key));
        }

        Map<String, String> map2 = new HashMap<>();
        map2.put("2", "Shaded Starlight");
        map2.put("1", "For An Angel");
        map2.put("6", "Born Slippy NUXX.");
        map2.put("5", "The Night");
        map2.put("4", "Children");
        map2.put("3", null);
        map2.put(null, "Face To Face");

        //NOT THE SAME ORDER AS INSERTED
        Iterator<String> it2 = map2.keySet().iterator();
        while(it2.hasNext()){
            String key = it2.next();
            System.out.println("Key: " + key);
            System.out.println("\tValue: " + map2.get(key));
        }
    }
}
