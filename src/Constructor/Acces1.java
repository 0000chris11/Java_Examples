
package Constructor;

/**
 *
 * @author C0FII
 */
public class Acces1 {
      public static void main(String[] args){
            System.out.println("\nAcces1 Main");
            Data dt =  new Data("Acces1 Main");
            
            System.out.println("\t" + dt.Album);
            System.out.println("\t" + Data.Album_S);
            
            Acces2 a2 =  new Acces2();
            Acces3 a3 = new Acces3();
            Acces4 a4 = new Acces4();
      }
}
