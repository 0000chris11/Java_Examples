package Basic;


import java.util.Scanner;

public class Scanner_EJ {

      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            //1
            String nombre = sc.nextLine();//Read what you type (save in variable)
            System.out.println(nombre);//Show what you type

            //2
            System.out.print(sc.nextLine());//Quick Way

      }
}
