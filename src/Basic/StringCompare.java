package Basic;


public class StringCompare {

      public static void main(String[] args) {
            String a = "grep";
            String b = "shy";
            String c = "SHY";

            if (a.equals("grep")) {//Only when comparing String you should use .equals()
                  System.out.println("YES");
            }
            if (b.equalsIgnoreCase(c)) {
                  System.out.println("YES Again");
            }
            //---STARS-WITH-&-ENDS-WITH------------------------------------------------
            String[] words = {"Usagi Tsukino", "Ami Mizuno", "Makoto Kino", "Minako Aino",
                   "Rei Hino"};

            for (String w : words) {
                  if (w.startsWith("M")) {
                        System.out.println(w + "--- stars with M");
                  }
            }//------------------------------------------------------------------------------------------------
            System.out.println("");//JUMP
            //------------------------------------------------------------------------------------------------
            for (String w : words) {
                  if (w.endsWith("ino")) {
                        System.out.println(w + "--- stars with ino");
                  }
            }
            System.out.println("");//JUMP
            //---SEARCH-FOR-CHARACTER--------------------------------------------------
            String d = "whatagreatperformancefromdanavadan";
            System.out.println(d.indexOf("p"));
            System.out.println(d.indexOf("at", 5));
            System.out.println(d.indexOf("x"));//False = -1;
            System.out.println("");//JUMP
            
            String e = "       mArio pArty       ";
            System.out.println(e.replace("p", "f"));//replace a character
            System.out.println(e.toUpperCase());
            System.out.println(e.toLowerCase());
            System.out.println(e.trim());//gets rid off the spaces
      }

}
