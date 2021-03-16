package Lists;

public class ArrayDouble {

      public static void main(String args[]) {
            int array1[][] = {{1, 2, 3, 4, 5, 6}, {11, 22, 33, 44, 55, 66, 77}};
            int array2[][] = {{13, 20, 7}, {2, 4, 6, 8, 10}, {0, 100, 50, 30, 40, 70}};

            //System.out.println(array1[1][5]);
            System.out.println("length of the array " + array1.length);
            System.out.println("length of the row " + array1[0].length);
            System.out.println("length of the 2nd row " + array1[1].length);
            //System.out.println(array2.length);

            System.out.println("First Array");
            display(array1);
            System.out.println("Second Array");
            display(array2);
      }

      public static void display(int x[][]) {
            for (int row = 0; row < x.length; row++) {
                  for (int column = 0; column < x[row].length; column++) {
                        System.out.print(x[row][column] + "\t");
                        //[0][0]
                        //[0][1]
                  }
                  System.out.println();
            }
      }
}
