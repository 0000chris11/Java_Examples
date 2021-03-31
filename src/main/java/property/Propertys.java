package property;

import java.util.Scanner;

import com.cofii2.methods.MList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Propertys {

    private StringProperty name = new SimpleStringProperty(this, "name", "Text");

    private StringProperty name() {
        return name;
    }

    private String getName() {
        return name.getValue();
    }

    private void setName(String value) {
        name.setValue(value);
    }

    public static void main(String[] args) {
        System.out.println("args: "+ args.length);
        MList.printFor(args, "ARGS");
        IntegerProperty i1 = new SimpleIntegerProperty(10);
        IntegerProperty i2 = new SimpleIntegerProperty();

        i2.bind(i1.multiply(2));

        System.out.println("i1: " + i1.getValue());
        System.out.println("i2: " + i2.getValue() + "\n");

        i1.setValue(20);

        System.out.println("i1: " + i1.getValue());
        System.out.println("i2: " + i2.getValue() + "\n");

        //////////////////////////////////////////////

        Propertys p = new Propertys();
        p.name().addListener((ob, oldValue, newValue) -> {
            System.out.println("\nLISTENING CHANGE");
            System.out.println("\tolValue: " + oldValue);
            System.out.println("\tnewValue: " + newValue);
        });

        Scanner sc = new Scanner(System.in);
        System.out.println("type new String");
        p.setName(sc.nextLine());

        ///////////////////////////////////////////////
        /*
         * CHANGES THE LABEL TEXT IN REAL TIME THROUGH THE TEXTFIELD TextField tf = new
         * TextField(); Label lb = new Label();
         * 
         * lb.textProperty().bind(tf.textProperty());
         */
    }
}
