package class_examples_d;

public class DateSet {

	private int day;
	private int month;
	private int year;
	private static int number = 0;
	
	public DateSet(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
		++number;
		
		System.out.printf("Today Date is: %s%n numbers of entries: %d%n" , this, number);
	}
	public String toString() {
		return String.format("%02d/%02d/%d", day, month, year);
	}
}
