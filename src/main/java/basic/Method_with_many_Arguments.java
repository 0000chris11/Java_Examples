package basic;


public class Method_with_many_Arguments {

    public static void main(String args[]) {
        System.out.println(average(5, 10, 7, 20, 100, 30));
    }

    public static int average(int... numbers) {
        int total = 0;
        for (int x : numbers) {
            total += x;
        }
        return total / numbers.length;
    }
}
