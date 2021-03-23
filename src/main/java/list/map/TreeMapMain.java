package list.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapMain {

    public static void main(String[] args) {
        //DOES NOT ALLOW NULLS AS KEYS AND ORGANIZE IN ABC ORDER
        Map<String, String> map = new TreeMap<>();
        map.put("6", "Shaded Starlight");
        map.put("4", "For An Angel");
        map.put("3", "Born Slippy NUXX.");
        map.put("5", "The Night");
        map.put("2", "Children");
        map.put("1", null);

        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println("Key: " + key);
            System.out.println("\tValue: " + map.get(key));
        }

        System.out.println();
        for(Entry<String, String> x : map.entrySet()){
            System.out.println("Key: " + x.getKey());
            System.out.println("\tValue: " + x.getValue());
        }
    }
}
