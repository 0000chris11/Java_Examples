package Array_List;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Array {
      //INGRESAR 6 NUMEROS POR PANTALLA 
      //3 enteros
      //3 decimales
      //los enteros almacenarlos en un arreglo int y 
      //los decimales en un arreglo de tipo doble

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            JOptionPane.showMessageDialog(null, "Introduza valores enteros");
            //declaracion de arreglo entero
            int[] enteros = new int[3];
            enteros[0] = sc.nextInt();
            enteros[1] = sc.nextInt();
            enteros[2] = sc.nextInt();

            JOptionPane.showMessageDialog(null, "Introduza decimales");
            //declaracion de un arreglo decimal
            double[] decimales = new double[3];
            decimales[0] = sc.nextDouble();
            decimales[1] = sc.nextDouble();
            decimales[2] = sc.nextDouble();

            //decimales[cont] = sc.nextDouble();
            for (int cont = 0; cont < 3; cont++) {
                  JOptionPane.showMessageDialog(null, enteros[cont]);
            }
            for (int cont = 0; cont < 3; cont++) {
                  JOptionPane.showMessageDialog(null, decimales[cont]);
            }
      }

}
