package java8;

import java.util.ArrayList;
import java.util.List;

class StreamEx {

    private List<String> list = new ArrayList<>();
    private List<String> listNumbers = new ArrayList<>();

    StreamEx() {
        list.add("Shy Guy");
        list.add("Mario World");
        list.add("Is hard");
        list.add("Dodge them");
        list.add("Second and a half");
        list.add("Smell the fish");
        list.add("Ummmm");
        list.add("Wahoooo!");

        listNumbers.add("1");
        listNumbers.add("2");
        listNumbers.add("3");
        listNumbers.add("4");
        listNumbers.add("5");
    }

    private void mapEx() {
        System.out.println("########## LIST (MAPEX)");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("########## LIST-NUMBERS (MAPEX)");
        listNumbers.stream().map(Integer::parseInt).forEach(System.out::println);        
    }

    private void limitEx(){
        System.out.println("########## LIST (LIMITEX)");
        list.stream().limit(4).forEach(System.out::println);
    }

    private void streamVsParallelStream(){
        System.out.println("########## LIST (streamVsParallelStream 1)");
        list.stream().forEach(System.out::println);
        System.out.println("########## LIST (streamVsParallelStream 2)");
        //NEW THREAD
        list.parallelStream().forEach(System.out::println);
    }
    public static void main(String[] args) {
        StreamEx ex = new StreamEx();
        ex.streamVsParallelStream();
    }
}
