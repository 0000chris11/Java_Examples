package Advanced;
public class Recursion {

      public static void main(String[] args) {
            System.out.println(fact(4));
      }

      public static long fact(long n) {
            if (n <= 1) {
                  return 1;
            } else {
                  return n * fact(n - 1);
            }
      }

}
