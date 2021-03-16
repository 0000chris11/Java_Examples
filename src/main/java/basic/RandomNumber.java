package basic;


import java.util.Random;

public class RandomNumber {

      public static void main(String args[]) {
            Random ro = new Random();
            int number;

            for (int count = 1; count <= 20; count++) {
                  number = 1 + ro.nextInt(6);//0 to 5 add 1+ = 1 to 6
                  System.out.println(number);
            }
      }
}
