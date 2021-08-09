package enum_type;

import java.util.EnumSet;

public class EnumMain {

	public static void main(String args[]) {
		for(EnumCl lenum : EnumCl.values()) {
			System.out.printf("%s\t%s\t%s%n", lenum, lenum.getDesc(), lenum.getAge());
		}
		System.out.println("\nNext but arrenged\n");
		for(EnumCl lenum: EnumSet.range(EnumCl.ROXAS, EnumCl.XION)) {
			System.out.printf("%s\t%s\t%s%n", lenum, lenum.getDesc(), lenum.getAge());
		}
	}
}
