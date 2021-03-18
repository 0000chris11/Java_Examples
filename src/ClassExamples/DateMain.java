package ClassExamples;

public class DateMain {
	public static void main(String args[]) {
		DateSet ds = new DateSet(1,30,1996);
		DateSet ds1 = new DateSet(2,2,1987);
		DateSet2 dsse = new DateSet2("Christopher",ds);
		
		System.out.println("\n"+dsse);
	}
}
