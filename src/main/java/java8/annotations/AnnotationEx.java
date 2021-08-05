package java8.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class AnnotationEx {
    
    @Retention(RetentionPolicy.RUNTIME)
    @interface Peoples{
        People[] value() default {};
    }

    @Repeatable(value = Peoples.class)
    @interface People{
        String value();
        String name() default "none";
        int age() default 0;
    }
    //----------------------------------------
    @People("Annotation 1")
    @People("Annotation 2")
    interface PeopleInterface{

    }
    //----------------------------------------
    public static void main(String[] args) {
        People[] peopleArray = PeopleInterface.class.getAnnotationsByType(People.class);
        System.out.println("peopleArray: " + peopleArray.length);
    }
}
