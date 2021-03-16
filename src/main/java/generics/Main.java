package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private void listarUpperBounded(List<? extends Persona> list) {
        for (Persona p : list) {
            System.out.println(p.getName());
        }
    }

    private void listarLowerBounded(List<? super Alumno> list) {
        for (Object p : list) {
            if (p instanceof Alumno) {
                System.out.println(((Alumno)p).getName());
            }else{
                System.out.println(p.getClass().getName());
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        List<Persona> list = new ArrayList<>();
        list.add(new Alumno("Fred"));
        list.add(new Alumno("Mark"));
        list.add(new Profesor("Martin"));

        m.listarUpperBounded(list);
        m.listarLowerBounded(list);
    }
}
