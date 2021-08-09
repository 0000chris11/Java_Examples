package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<PersonaImplComparable> list = new ArrayList<>(5);
        list.add(new PersonaImplComparable(1, "Todd", 3));
        list.add(new PersonaImplComparable(2, "Lol", 8));
        list.add(new PersonaImplComparable(3, "Youn", 14));
        list.add(new PersonaImplComparable(4, "Lol+", 10));
        /*
        Collections.sort(list, new NameComporator());
        for(Persona x : list){
            System.out.println(x.getId() + "-" + x.getName() + "-" + x.getAge());
        }
        */
        Collections.sort(list);
        for(PersonaImplComparable x : list){
            System.out.println(x.getId() + "-" + x.getName() + "-" + x.getAge());
        }
    }
}
