package Basic;


import java.util.Random;
import java.util.Scanner;

public class Array_Random {

    public static void main(String args[]) {
        System.out.println("Index\tValue");
        int sum = 0;
        int list[] = {4, 6, 8, 10, 13, 15};
        for (int count = 0; count < list.length; count++) {
            sum += list[count];
            System.out.println(count + "\t" + list[count]);//Show all elements
        }
        System.out.println("\nSusma = " + sum + "\n");//Shows the summing of all Elements
        //---------------------------------------------------------------------------
        System.out.println("-----------------------------------------------------------------");
        //---------DOESN'T-WORK-PROPERLY----------------------------------------------------------------
        Random rd = new Random();
        int list2[] = new int[7];
        int thing = 0;
        for (int roll = 0; roll < 6; roll++) {
            thing = ++list2[1 + rd.nextInt(6)];
            System.out.println("element " + thing + "\n");
            System.out.println(roll + ": " + list2[roll] + "\n");
        }
        //----------------------------------------------------------------------------
        System.out.println("-----------------------------------------------------------------");
        //----------------------------------------------------------------------------
        System.out.println("\nTEST 3\n");
        Scanner sc = new Scanner(System.in);
        int list3[] = new int[8];
        System.out.println("Add Number: ");
        for (int count = 0; count < list3.length; count++) {//Add elements by keyboard
            list3[count] = sc.nextInt();
        }
        for (int x : list3) {//Show the elements on screen
            System.out.println("\n" + x);
        }
        //FIX ERROR

    }
}
