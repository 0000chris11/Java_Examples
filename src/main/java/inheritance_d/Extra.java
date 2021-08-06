package inheritance_d;

public class Extra {

	private SuperExt1[] array = new SuperExt1[2];
	private int x = 0;

	// --------------------------------------------------------------
	void doFrom(Super x) {// passing an object
		System.out.println("this comes from a third class: ");
		x.normalMethod1();
	}

	void addObjects(SuperExt1 n) {
		if (x < array.length) {
			array[x] = n;// adding
			System.out.println("an objects has been added to the elements: " + x);
			x++;

		}
	}
}
