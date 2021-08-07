package list.array.examples;

import java.util.Scanner;

class Array {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduzca valores enteros");
            //declaracion de arreglo entero
            int[] enteros = new int[3];
            enteros[0] = sc.nextInt();
            enteros[1] = sc.nextInt();
            enteros[2] = sc.nextInt();

            System.out.println("Introduza decimales");
            //declaracion de un arreglo decimal
            double[] decimales = new double[3];
            decimales[0] = sc.nextDouble();
            decimales[1] = sc.nextDouble();
            decimales[2] = sc.nextDouble();

            //decimales[cont] = sc.nextDouble();
            for (int cont = 0; cont < 3; cont++) {
                  System.out.println("\t" + enteros[cont]);
            }
            for (int cont = 0; cont < 3; cont++) {
                  System.out.println("\t" + decimales[cont]);
            }

            sc.close();
      }

}
