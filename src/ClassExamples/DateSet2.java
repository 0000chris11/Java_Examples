package ClassExamples;

public class DateSet2 {
	private String name;
	private DateSet birthday;
	
	public DateSet2(String n, DateSet bd) {
		name = n;
		birthday = bd;
		
	}
	
	public String toString() {
		return String.format("My Name is: %s\n and my birthday is: %s", name, birthday);
	}
}
