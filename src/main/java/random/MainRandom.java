/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import com.cofii2.methods.MOthers;
import com.cofii2.methods.MString;
import java.util.Scanner;

/**
 *
 * @author C0FII
 */
public class MainRandom {

      public static void main(String[] args) {

            String[] arrays = MString.getTags("Throw me!; Buckle your pants!; EEEYesu...", 3);
            for(String x : arrays){
                  System.out.println("\t" + x);
            }
            
            int min = 2;
            int max = 164;
            Scanner sc = new Scanner(System.in);
            while (true) {
                  String v = sc.nextLine();
                  System.out.println("Random Number (" + min + " ," + max + "): " + MOthers.getRandomNumber(min, max));
                  if(v.equals("0")){
                        break;
                  }
            }
      }
}
