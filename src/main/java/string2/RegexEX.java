package string2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEX {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Pattern p = null;
        Matcher m = null;
        String line = "";

        while (!line.equals("EXIT")) {
            System.out.println("INSERT STRING");
            line = sc.nextLine();

            p = Pattern.compile(".");// ANY CHARACTER (JUST ONE)
            m = p.matcher(line);
            System.out.println("EX 1 (.): " + m.matches());

            p = Pattern.compile("....s");// THE FIFTH CHARACTER SHOULD BE A "s" AND IT HAS TO BE THE LAST ONE
            m = p.matcher(line);
            System.out.println("EX 2 (....s): " + m.matches());

            p = Pattern.compile("[abc]");//MATCH JUST ONE OF THESE CHARACTERS
            m = p.matcher(line);
            System.out.println("EX 3 ([abc]): " + m.matches());

            p = Pattern.compile("[^abc]");//MATCH ANY CHARACTER BUT THIS ONES
            m = p.matcher(line);
            System.out.println("EX 3 ([^abc]): " + m.matches());

            p = Pattern.compile("[^Once]");//STAR OF THE STRING HAS TO BE "Once"
            m = p.matcher(line);
            System.out.println("EX 3 (/[^Once]): " + m.matches());
        }
    }
}
