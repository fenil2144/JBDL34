package Class2;

import java.io.IOException;
import java.sql.SQLException;

class Parent{
	void msg() throws ArithmeticException{
		System.out.println("Parent Class Method");
	}
}
public class TestExceptionChild extends Parent{
	
	void msg() throws RuntimeException{
		System.out.println("Child Class Method");
	}
	

}
