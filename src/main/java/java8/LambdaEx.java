package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class LambdaEx implements InterDefault{

    private void lambdaComparation(){
        //------------------------------------------------
        //WITHOUT LAMBDA
        List<String> list = new ArrayList<>();
        list.add("Take a chance");
        list.add("Dance like a man");
        list.add("Let's show people how to do it");
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("LIST: ");
        for(String x : list){
            System.out.println("\t" + x);
        }
        //WITH LAMBDA
        List<String> list2 = new ArrayList<>();
        list2.add("Eyes");
        list2.add("Without");
        list2.add("A");
        list2.add("Face");
        Collections.sort(list2, (String o1, String o2) -> o1.compareTo(o2));//<------
        System.out.println("LIST (Lambda): ");
        for(String x : list2){
            System.out.println("\t" + x);
        }
        //WITH LAMBDA INSTANCE REFERENCE
        List<String> list3 = new ArrayList<>();
        list3.add("Vector");
        list3.add("To");
        list3.add("The");
        list3.add("Heavens");
        Collections.sort(list3, String::compareTo);//<------
        System.out.println("LIST (Lambda instance Reference): ");
        for(String x : list3){
            System.out.println("\t" + x);
        }
        //------------------------------------------------
        //WITHOUT LAMBDA
        FInterTwoDouble is = new FInterTwoDouble(){
            @Override
            public double getDoubleValue(double d1, double d2) {
                return d1 + d2;
            }
        };
        System.out.println("getDoubleValue: " + is.getDoubleValue(5.0, 1.0));
        //WITH LAMBDA
        //1
        FInterTwoDouble is2 = (double d1, double d2) -> d1 + d2;
        System.out.println("getDoubleValue (Lambda): " + is2.getDoubleValue(3.0, 10.0));
        //2
        FInterTwoDouble is3 = (double d1, double d2) -> {
            double returnValue = 0.0;
            returnValue += 10.0 + d1 + d2;
            return returnValue;
        };
        System.out.println("getDoubleValue (Lambda 2): " + is3.getDoubleValue(7.2, 8.3));
        //3
        FInterEmptyString iss = () -> "Kobito ni wa narenai Kedo";
        System.out.println("getStringValue (Lambda 3): " + iss.getStringValue());
    }
    
    private static String staticReference(){
        return "Reference to a Static Method";
    }
    private static double staticReference2(double x, double y){
        return x + y;
    }

    private void referencing(){
        //STATIC---------------------
        FInterEmptyString is = LambdaEx::staticReference;
        System.out.println("STATIC REFERENCE: " + is.getStringValue());

        FInterTwoDouble is2 = LambdaEx::staticReference2;
        System.out.println("STATIC REFERENCE 2: " + is2.getDoubleValue(12.5, 7.5));
        //INSTANCE-------------------
        ClassReference cr = new ClassReference();
        FInterVoidThree is3 = cr::defaultAction;
        System.out.println("INSTANCE REFERENCE: ");
        is3.action(1, "La", "Follia");

        FInterVoidThree is4 = new ClassReference()::defaultAction;
        System.out.println("INSTANCE REFERENCE: ");
        is4.action(1, "La", "Follia");

        FInterClassThree is5 = ConstructorReference::new;
        ConstructorReference cons = is5.create(13, "Me", 99);
        System.out.println("CONSTRUCTO REFERENCE: " + cons.getId() + " - " + cons.getName() + " - " + cons.getAge());
    }
    //------------------------------------------------------------
    LambdaEx(){
        Scanner sc = new Scanner(System.in);

        System.out.println("SELECT: \n");
        int op = sc.nextInt();
        if(op == 1){
            lambdaComparation();
        }else if(op == 2){
            defaultAction();//FROM InterDefault
        }else if(op == 3){
            referencing();
        }

        sc.close();
    }
    public static void main(String[] args) {
        new LambdaEx();
    }
    //------------------------------------------------------------
    @Override
    public String doSomething() {
        return "Returning a value";
    }
}
