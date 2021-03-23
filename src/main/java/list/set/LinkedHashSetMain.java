package list.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMain {
    
    public static void main(String[] args) {
        //NO REPITTED ELEMENTS AND KEEPS INSERTION-ORDER
        Set<String> list = new LinkedHashSet<>();
        list.add("Yozora");
        list.add("MOM");
        list.add("Luxord");
        list.add("MOM");
        list.add("Demyx");
        list.add("Luxu");
        list.add("MOM");

        System.out.println();
        for(String x : list){
            System.out.println(x);
        }

        //NO REPITTED ELEMENTS AND KEEPS INSERTION-ORDER WITH HASHCODE AND EQUALS BUT WITHOUT COMPARABLE
        Set<Persona> list2 = new LinkedHashSet<>();
        list2.add(new Persona(1, "Sada"));
        list2.add(new Persona(2, "Rosie"));
        list2.add(new Persona(3, "Mikomi"));
        list2.add(new Persona(1, "Ryu"));
        list2.add(new Persona(2, "Kawaii"));
        list2.add(new Persona(3, "Mikomi"));
        list2.add(new Persona(3, "Mikomi"));
    }
}
