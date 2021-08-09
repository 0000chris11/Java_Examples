package basic;


import java.util.Scanner;

public class EvenOdd {

// pares multiplicar y si son impares dividir
      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Escriba primer numero: ");
            int numero1 = sc.nextInt();

            System.out.print("Escriba segundo numero: ");
            int numero2 = sc.nextInt();
            //-----------------------------------------------------------------------------------------------
            System.out.println("\n?? " + numero1 % 2);
            if (numero1 % 2 == 0 && numero2 % 2 == 0) {
                  //IF BOTH NUMBERS ARE PAR
                  System.out.print("\n" + numero1 * numero2);
            } else {
                  System.out.print(numero1 / numero2);
            }

            sc.close();
      }
}
