package list.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

    public static void main(String[] args) {
        //NO REPITTED VALUES AND ASCENDED ORDER
        Set<String> list = new TreeSet<>();
        list.add("Song");
        list.add("Album");
        list.add("Artist");
        list.add("Year");
        list.add("Genre");
        list.add("Song");
        list.add("Song");

        System.out.println();
        for(String x : list){
            System.out.println(x);
        }

        //NO REPITTED VALUES AND ASCENDED ORDER WHIT COMPARABLE, HASHCODE AND EQUALS
        Set<Persona> list2 = new TreeSet<>();
        list2.add(new Persona(1, "Rayman"));
        list2.add(new Persona(2, "Castlevania"));
        list2.add(new Persona(3, "Silent Hill"));
        list2.add(new Persona(4, "Silent Hill"));
        list2.add(new Persona(1, "Rayman"));

        System.out.println();
        for(Persona x : list2){
            System.out.println(x.getId() + " - " + x.getName());
        }
    }
}
