package Basic;


public class If_statement {

    public static void main(String args[]) {
        int age = 33;
        int count = 1;
        System.out.println(age < 30 ? "Young" : "Old\n");

        if (count > 10) {
            System.out.println("KEY 1");
        } else if (count < 1) {
            System.out.println("KEY 2");
        } else if (count < 5) {
            System.out.println("KEY 3");
        }
    }
}
