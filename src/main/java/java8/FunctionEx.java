package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class FunctionEx {
    
    private Function<Integer, String> fuctionStringNumber = x -> ">> " + x.toString() + " <<";

    private void filter(List<String> list, Consumer<String> consumer, int length){ 
        list.stream().filter(getFilterLogic(length)).forEach(consumer);
    }

    private Predicate<String> getFilterLogic(int length){
        return s -> s.length() < length;
    }
    public static void main(String[] args) {
        FunctionEx ex = new FunctionEx();

        System.out.println("Result: " + ex.fuctionStringNumber.apply(13));

        List<String> list = new ArrayList<>(10);
        list.add("VL");
        list.add("Function");
        list.add("VLController");
        int length = 4;
        ex.filter(list, s -> System.out.println(s + " is below " + length + " length"), length);
    }
}
