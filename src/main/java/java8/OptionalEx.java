package java8;

import java.lang.StackWalker.Option;
import java.util.Optional;

class OptionalEx {

    private void orElseEx(String value){
        Optional<String> optional = Optional.ofNullable(value);
        System.out.println("orElseEx Result: " + optional.orElse("NULL VALUE"));
    }
    private void orElseThrowEx(String value){
        Optional<String> optional = Optional.ofNullable(value);
        System.out.println("orElseThrowEx Result: " + optional.orElseThrow(IllegalArgumentException::new));
    }
    private void isPresentEx(String value){
        Optional<String> optional = Optional.ofNullable(value);
        System.out.println("isPresentEx Result: " + optional.isPresent());
    }

    public static void main(String[] args) {
        OptionalEx ex = new OptionalEx();
        ex.orElseEx(null);
        
        ex.isPresentEx("afjbajkbskfj");
        ex.isPresentEx(null);

        ex.orElseThrowEx(null);

    }
}
