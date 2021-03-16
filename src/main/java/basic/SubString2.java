package basic;

public class SubString2 {

      public static void main(String[] args) {
            String word = "Meitantei, Conan";
            //    index          012345678
            String subl = word.substring(0, 3);
            //TAKING PART OF THE WORD
            System.out.println("The sub of " + word + "[0,3] is: " + subl);
            System.out.println(word.length());

            System.out.println(word.lastIndexOf(","));
            //Getting Lasp Part of the word
            System.out.println(word.substring(word.indexOf(",") + 2, word.length()));
            //Getting the beggining part of the word
            System.out.println(word.substring(0, word.indexOf(",") + 1));
            System.out.println(word.substring(0, word.lastIndexOf(",") + 1));
            //+++++++++++++++++++++++++++++++++++++++++
            String word3 = "AAAAA;AAAAA vvvvvvv DsF;dGd";
            word3 = word3.replaceAll("\\s", "");
            System.out.println("WORD 3: " + word3);
            int zz = word3.length();
            //+++++++++++++++++++++++++++++++++++++++++
            //Uppercase
            //System.out.print("Please give a string: ");
            //String x = in.next();
            //int z = x.length();
            /*for (int y = 0; y < z; y++) {
                  if (Character.isUpperCase(x.charAt(y))) {
                        char w = x.charAt(y);
                        
                  }
            }
           
             */
            int co = 0;
            char ch;
            //char brak = ';';
            for (int a = 0; a < zz; a++) {
                  ch = word3.charAt(a);
                  System.out.println(ch);
                  if(ch == ';'){
                        System.out.println("One with ;: "+ ch);
                        co++;
                  }
                  

            }
            System.out.println("The characters that contain ; are: ");
            //Uppercase

      }
}
