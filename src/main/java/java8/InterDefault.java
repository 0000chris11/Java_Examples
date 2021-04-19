package java8;

interface InterDefault {
    
    String doSomething();

    default void defaultAction(){
        System.out.println("Default Implementation ");
    }
}
