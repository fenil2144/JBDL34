package Class3;

@FunctionalInterface
interface MyInterface{
	
	public int getSum(int a, int b);
	
	default void printString() {
		System.out.println("I am default Method");
	}
}

public class FunctionalInterfaceTest{
	public static void main(String[] args) {
		
		MyInterface interf = new MyInterface() {
			
			@Override
			public int getSum(int a, int b) {
				return (a+b);
			}
			
			@Override
			public void printString() {
				System.out.println("I am default Method");
			}
			
		};
		
		System.out.println(interf.getSum(2,3));
		interf.printString();
		
		//(Argument List) -> {Body}
		MyInterface interfa = (a, b) -> {return (a+b);};
		System.out.println(interf.getSum(3, 4));
	}
	

	
	

}
