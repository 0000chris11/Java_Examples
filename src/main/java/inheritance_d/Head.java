package inheritance_d;

public class Head {

	public static void main(String args[]) {
		SuperExt1 in1 = new SuperExt1();
		SuperExt2 in2 = new SuperExt2();

		in1.normalMethod1();
		in2.normalMethod1();

		System.out.println();

		in1.normalMethod2(7);
		in2.normalMethod2(13);// Override Method
		// -------------------------------------------------------------------
		System.out.println("\nPOLYMORPHISM\n");
		// Polymorphism
		Super[] ins1 = new Super[2];
		ins1[0] = new SuperExt1();// this array is holding objects from other classes
		ins1[1] = new SuperExt2();

		for (int x = 0; x < 2; ++x) {
			ins1[x].normalMethod2(x);
		}
		System.out.println("\nUSING A METHOD FROM ANOTHER CLASS IN A THIRD CLASS\n");
		// ---------------------------------------------------------------------
		Extra call = new Extra();
		call.doFrom(in1);

		System.out.println("\n");
		in1.abstractMethod1();
		in2.abstractMethod1();
		// ---------------------------------------------------------------------
		System.out.println("ADDING OBJETS TO  A LIST");

		Extra eo = new Extra();
		SuperExt1 n1 = new SuperExt1();
		SuperExt1 n2 = new SuperExt1();
		eo.addObjects(n1);
		eo.addObjects(n2);
		eo.addObjects(new SuperExt1());

		// -------------------------------------------------------------------
		System.out.println("\nADDING OBJECTS FROM MULTIPLE CLASSES TO A LIST\n");
		Super[] sl = new Super[2];
		sl[0] = in1;
		sl[1] = in2;

		for (Super x : sl) {
			x.abstractMethod2();
		}
	}
}
