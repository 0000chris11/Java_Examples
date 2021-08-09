package comparator;

import java.util.Comparator;

public class NameComporator implements Comparator<PersonaImplComparable> {

    @Override
    public int compare(PersonaImplComparable o1, PersonaImplComparable o2) {
        return o1.getName().compareTo(o2.getName());
    }


    
}
