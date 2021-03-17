package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private void listarUnBounded(List<?> list) {
        System.out.println();
        for (Object p : list) {
            if (p instanceof Alumno) {
            System.out.println("\t" + ((Alumno) p).getName());
            }else if(p instanceof Profesor){
                System.out.println("\t" + ((Profesor) p).getName());
            }else if(p instanceof Persona){
                System.out.println("\t" + ((Persona) p).getName());
            }
        }
    }

    private void listarUpperBounded(List<? extends Persona> list) {
        System.out.println();
        for (Persona p : list) {
            System.out.println("\t" + p.getName());
        }
    }

    private void listarLowerBounded(List<? super Alumno> list) {
        System.out.println();
        for (Object p : list) {
            if (p instanceof Alumno) {
                System.out.println("\t" + ((Alumno)p).getName());
            }else{
                System.out.println("\t" + ((Persona)p).getName());
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        List<Persona> list = new ArrayList<>();
        list.add(new Alumno("Fred"));
        list.add(new Alumno("Mark"));
        list.add(new Profesor("Martin"));
        list.add(new Persona("PP"));

        m.listarUnBounded(list);
        m.listarUpperBounded(list);
        m.listarLowerBounded(list);
    }
}
