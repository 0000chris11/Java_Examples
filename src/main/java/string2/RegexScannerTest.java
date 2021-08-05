package string2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cofii2.stores.CC;

class RegexScannerTest {

    private static final String FIXED_STRING = "Mr. Daniel";

    RegexScannerTest() {
        Scanner sc = new Scanner(System.in);
        Pattern pattern;
        Matcher matcher;

        String linePattern;
        String line;
        while (true) {
            System.out.println("Insert Regex: ");
            linePattern = sc.next();
            if(linePattern.equals("EXIT")){
                break;
            }
            pattern = Pattern.compile(linePattern);

            int r = 1;
            while (true) {
                System.out.println("\t Insert text for pattern <" + linePattern + ">: ");
                line = sc.next();
                if (line.equals("CHANGE")) {
                    break;
                }else if(line.equals("FIXED")){
                    line = FIXED_STRING;
                }
                matcher = pattern.matcher(line);
                //---------------------------------------
                
                System.out.print("\t\t" + r + " Matches: ");
                if(matcher.matches()){
                    System.out.println(CC.GREEN + "true" + CC.RESET);
                }else{
                    System.out.println(CC.RED + "false" + CC.RESET);
                }
                System.out.print("\t\t" + r + " Find: ");
                if(matcher.find()){
                    System.out.println(CC.GREEN + "true" + CC.RESET);
                }else{
                    System.out.println(CC.RED + "false" + CC.RESET);
                }
                r++;
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        new RegexScannerTest();
    }
}
