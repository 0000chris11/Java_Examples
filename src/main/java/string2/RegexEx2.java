package string2;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx2 {

    public static void main(String[] args) {
        String text = "Yes no no no yes no NO YES YES yes no";
        Pattern p = Pattern.compile("yes", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);

        //System.out.println("looking at" m.lookingAt()); RETURNS TRUE IF MATCHES INT THE BEGINING OF THE STRING
        
        int count = 0;
        while(m.find()){
            count++;
            System.out.println("Find N" + count + "| start: " + m.start() + " | end: " + m.end());
        }

        Connection con;
        con.a
    }
}
