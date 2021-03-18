package Inheritance;
abstract public class Super {
	//You can't create objects from this class cuz it is abstract
	//When you have an abstract method the class has to be abstract to,
		//but no the other way around
	
	//CLASS SUPER WITH 3 METHODS
	public void stage() {
		System.out.println("boioo!");
	}
	public void setThing(int x) {
		System.out.println("this is the original method: "+x);
	}
	public abstract void otherThing();//Abstract methods can't have a body
	public abstract void noise();
}