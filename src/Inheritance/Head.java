package Inheritance;

public class Head {
	public static void main(String args[]) {
		Num_1 in1 = new Num_1();
		Num_2 in2 = new Num_2();
		
		in1.stage();
		in2.stage();
		
		System.out.println();
		
		in1.setThing(7);
		in2.setThing(13);// Override Method
		//-------------------------------------------------------------------
		System.out.println("\nPOLYMORPHISM\n");
		//Polymorphism
		Super ins1[] = new Super[2];
		ins1[0] = new Num_1();//this array is holding objects from other classes
		ins1[1] = new Num_2();
		
		for(int x=0;x<2;++x) {
			ins1[x].setThing(x);
		}
		System.out.println("\nUSING A METHOD FROM ANOTHER CLASS IN A THIRD CLASS\n");
		//---------------------------------------------------------------------
		Extra call = new Extra();
		call.dofrom(in1);
		
		System.out.println("\n");
		in1.otherThing();
		in2.otherThing();
		//---------------------------------------------------------------------
		System.out.println("ADDING OBJETS TO  A LIST");
		
		Extra eo = new Extra();
		Num_1 n1 = new Num_1();
		Num_1 n2 = new Num_1();
		Num_1 n3;
		eo.addObjects(n1);
		eo.addObjects(n2);
		eo.addObjects(n3 = new Num_1());
		
		//-------------------------------------------------------------------
		System.out.println("\nADDING OBJECTS FROM MULTIPLE CLASSES TO A LIST\n");
		Super[] sl = new Super[2];
		sl[0] = in1;
		sl[1] = in2;
		
		for(Super x:sl) {
			x.noise();
		}
	}
}
