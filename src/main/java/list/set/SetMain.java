package list.set;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {
        Set<String> list1 = new HashSet<>();
        list1.add("Sora");
        list1.add("Klonoa");
        list1.add("Kurapika");
        list1.add("Kurapika");
        list1.add("Finn");
        list1.add("Sora");
        list1.add("Sora");

        System.out.println();
        for(String x : list1){
            System.out.println(x);
        }

        Set<Persona> list2 = new HashSet<>();
        list2.add(new Persona(1, "Usagi Tsukino"));
        list2.add(new Persona(2, "Pinkie Pie"));
        list2.add(new Persona(3, "Inaho Misora"));
        list2.add(new Persona(4, "Haibara Ai"));
        list2.add(new Persona(2, "Pinkie Pie"));
        list2.add(new Persona(2, "Pinkie Pie"));
        list2.add(new Persona(1, "Usagi Tsukino"));
        list2.add(new Persona(2, "Pinkie Pie"));
        list2.add(new Persona(2, "Pinkie Pie"));

        System.out.println();
        for(Persona x : list2){
            System.out.println(x.getId() + " - " + x.getName());
        }
    }

}
