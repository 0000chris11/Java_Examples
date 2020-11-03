package Basic;


import java.util.Scanner;

public class While_doWhile {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("TEST ONE:\n");
            int ocon = 1;
            while (ocon <= 10) {
                  System.out.println(ocon);
                  ocon++;
            }//------------------------------------------------------------------------

            System.out.println("TEST TWO:\n");
            int contador = 0;
            while (true) {
                  contador++;
                  System.out.println("contador: " + contador);
                  System.out.println("Escriba 1 para salir: ");
                  int opcion = sc.nextInt();

                  if (opcion == 1) {
                        break;
                  }
            }//--------------------------------------------------------------------------

            System.out.println("TEST THREE:\n");//THE LOOP STAR AT LEAST ONE
            int anocon = 1;
            do {
                  System.out.println(anocon);
                  anocon++;
            } while (anocon <= 10);
      }

}
