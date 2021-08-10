package inheritance;

public abstract class Super {

	public void normalMethod1() {
		System.out.println("normalMethod1 called");
	}
	public void normalMethod2(int x) {
		System.out.println("normalMethod2 called: " + x);
	}

	//When you have an abstract method the class has to be abstract to, but no the other way around
	public abstract void abstractMethod1();//Abstract methods can't have a body
	public abstract void abstractMethod2();
}