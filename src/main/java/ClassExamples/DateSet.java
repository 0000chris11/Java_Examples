package ClassExamples;

public class DateSet {
	private int Day;
	private int Month;
	private int Year;
	private static int number = 0;
	
	public DateSet(int d, int m, int y) {
		Day = d;
		Month = m;
		Year = y;
		++number;
		
		System.out.printf("Today Date is: %s\n numbers of entries: %d\n" , this, number);
	}
	public String toString() {
		return String.format("%02d/%02d/%d", Day, Month, Year);
	}
}
