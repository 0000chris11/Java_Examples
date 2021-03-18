package String;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Christopher
 */
public class Pattern_Ex {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String original = "mi_SeeR";
            String nombre = "none";
            int c = 0;
            while (!nombre.equals("exit")) {
                  System.out.print((c++) + " - Type Word: ");
                  nombre = sc.nextLine();

                  Pattern pat = Pattern.compile(Pattern.quote(nombre), Pattern.CASE_INSENSITIVE);
                  System.out.println("\t" + pat);
                  Matcher match = pat.matcher(original);
                  System.out.println("Find: " + match.find());
            }
      }
}
