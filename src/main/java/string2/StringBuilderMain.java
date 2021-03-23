package string2;

public class StringBuilderMain {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        System.out.println("Initial Capacity: " + sb.capacity());
        sb.append("Is over").append(" now").append(", shall we").append(" I don't think so");
        System.out.println(sb.toString());
    }
}
