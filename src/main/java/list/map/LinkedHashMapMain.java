package list.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapMain {

    public static void main(String[] args) {
        //DOES NOT ALLOW NULLS AS KEYS AND MAINTAINS ITS ORDER
        Map<String, String> map = new LinkedHashMap<>();
        map.put("6", "Shaded Starlight");
        map.put("4", "For An Angel");
        map.put("3", "Born Slippy NUXX.");
        map.put("5", "The Night");
        map.put("5", "The Day");
        map.put("2", "Children");
        map.put("1", null);

        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println("Key: " + key);
            System.out.println("\tValue: " + map.get(key));
        }
    }
}
