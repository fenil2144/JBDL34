class Parent{
	protected void method1() {
		System.out.println("From Parent method1");
	}
	int x = 10;
}

class Child extends Parent{
	public void method1() {
		System.out.println("From Child Class");
	}
	int x =20;
}
class child2 extends Parent{
	public void method1() {
		System.out.println("From Child Class");
	}
}
public class MethodOverriding {
	
	public static void main(String args[]) {
		
		Parent obj1 = new Parent();
		obj1.method1();
		
		//Child obj2 = new child2(); siblings not allowed
		
		obj1 = new Child();
		obj1.method1();
		
		//variables are overriden
		System.out.println(obj1.x);
		
		// Child obj2 = (Child) new Parent(); Not allowed
		
	}

}
