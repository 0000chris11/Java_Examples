package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class MapEx {

    private Map<Integer, String> map = new HashMap<>();

    // -------------------------------------------
    MapEx() {
        map.put(1, "Disney Town");
        map.put(2, "OHHHHHHH");
        map.put(3, "My prisoner");
        map.put(4, "Whow");
        map.put(5, "Shoot");
        map.put(6, "About");
        map.put(7, "as Child");
        map.put(8, "you are my Child");
    }

    // -------------------------------------------
    private void putIfAbsentEx(int key, String value) {
        // DOES NOT OVERRIDE THE ELEMENT
        System.out.println("\nputIfAbsentEx");
        map.putIfAbsent(key, value);
    }

    private void computeIfPresent(int key) {
        System.out.println("\ncomputeIfPresent");
        map.computeIfPresent(key, (k, v) -> k + v);

    }

    private void getOrDefaultEx(int key) {
        System.out.println("\ngetOrDefaultEx");
        System.out.println("value: " + map.getOrDefault(key, "NO SUCH KEY"));
    }

    private void mapCollectEx(String containts) {
        System.out.println("\nmapCollectEx");
        Map<Integer, String> filteredMap = map.entrySet().stream().filter(e -> e.getValue().contains(containts))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        filteredMap.entrySet().forEach(System.out::println);
    }

    private void printMap() {
        System.out.println("\nprintMap");
        map.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        MapEx ex = new MapEx();
        ex.putIfAbsentEx(4, "Games");
        ex.computeIfPresent(2);
        ex.getOrDefaultEx(6);

        ex.printMap();

        ex.mapCollectEx("Child");
    }
}
