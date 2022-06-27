package Class2;

public class ExceptionDemo {
	
	public static void main(String args[]) throws ArithmeticException{
		
		computeDivision(0);
		try {
			computeDivision(0);
			
			
			
			
		}
		catch(ArithmeticException e) {
			System.out.println("I am in Catch block catching the Arithmetic exception");
		}
		catch(NullPointerException e) {
			System.out.println("I am handling Null Pointer Exception");
		}
		catch(Exception e) {
			
		}
		finally{
			System.out.println("I am in Finally Block");
		}
		
		//other code
		System.out.println("I am also useful!");
		
	}
	
	public static void computeDivision(int number) {
		int x = 100/number;
		System.out.println("X = "+x);
	}

}

abstract class A{
	
}
