package class_examples_d;

public class Game_borrow {
	private String Gamename;
	public void setName(String name) {
		Gamename = name;
	}
	public String getName() {
		return Gamename;
	}//----------------------------------------------------
	public void tell() {
		System.out.printf("Your Game is: %s", getName());
		System.out.println("\nYour Game is: " + getName());
	}
}
