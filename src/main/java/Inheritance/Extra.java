package Inheritance;

public class Extra {
	public void dofrom(Super x) {//passing an object
		System.out.println("this comes from a third class: "); 
			x.stage();
	}
	//--------------------------------------------------------------
	private Num_1[] list_1 = new Num_1[2];
	private int x=0;
	
	public void addObjects(Num_1 n) {
		if(x<list_1.length) {
			list_1[x]=n;//adding
			System.out.println("an objects has been added to the elements: "+x);
			x++;
			
		}
	}
}
