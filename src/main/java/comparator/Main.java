package comparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<Persona> list = new ArrayList<>(5);
        list.add(new Persona(1, "Todd", 3));
        list.add(new Persona(2, "Lol", 8));
        list.add(new Persona(3, "Youn", 14));
        list.add(new Persona(4, "Lol+", 10));
        /*
        Collections.sort(list, new NameComporator());
        for(Persona x : list){
            System.out.println(x.getId() + "-" + x.getName() + "-" + x.getAge());
        }
        */
        Collections.sort(list);
        for(Persona x : list){
            System.out.println(x.getId() + "-" + x.getName() + "-" + x.getAge());
        }
    }
}
