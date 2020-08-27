package Basic;


public class genericMethod {

      public static void main(String[] args) {
            Integer[] iray = {1, 2, 3, 4, 5, 6};
            Character[] cray = {'a', 'b', 'c', 'd', 'e', 'f'};
            String[] sray = {"P", "I", "N", "K", "I", "E"};

            printMe(iray);
            printMe(cray);
            printMe(sray);
            //-----------------------------------------------------------------------
            System.out.println(max(5, 8, 2));
            System.out.println(max("Goku", "Sora", "Twilight"));
      }
      //a generic method can have multiple types of data pass on it

      public static <T> void printMe(T[] i) {
            for (T x : i) {
                  System.out.printf("%s ", x);
            }
            System.out.println();
      }
      //??????????????????????????????????????????????????????????????????
      public static <T extends Comparable<T>> T max(T a, T b, T c) {
            T m = a;
            if (b.compareTo(a) > 0) {
                  m = b;
            }
            if (c.compareTo(m) > 0) {
                  m = c;
            }

            return m;
      }
}
