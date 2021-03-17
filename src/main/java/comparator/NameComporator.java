package comparator;

import java.util.Comparator;

public class NameComporator implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getName().compareTo(o2.getName());
    }


    
}
