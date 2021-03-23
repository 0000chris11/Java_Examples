package string2;

public class SplitEX {
    public static void main(String[] args) {
        String string = "each;doit;dumb;probably;dead;Wowwww; nice; clean; There!; Ok";
        String[] elements = string.split(";");

        for(String x:elements){
            System.out.println(x);
        }

        System.out.println();
        
        String string2 = "Lose me|I like that|Features|Let's Go|Ohhhhh| Shall we| What! | Do it!";
        String[] elements2 = string2.split("\\|", 4);

        for(String x:elements2){
            System.out.println(x);
        }
    }
}
