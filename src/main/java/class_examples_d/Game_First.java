package class_examples_d;
import java.util.Scanner;
public class Game_First {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insert Game name: ");
		String name = sc.nextLine();
		
		Game_borrow br = new Game_borrow();
		br.setName(name);
		br.tell();
		
	}

}
