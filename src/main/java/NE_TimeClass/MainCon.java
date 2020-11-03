package NE_TimeClass;

public class MainCon {
	public static void main(String args[]) {
		Time ot = new Time();
		
		ot.setTime(16, 3, 38);
		System.out.println(ot.showMilitary());
		System.out.println(ot.showNormal());
	}
	
	
}
