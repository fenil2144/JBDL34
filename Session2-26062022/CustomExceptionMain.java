package Class2;

class UserNotFoundException extends Exception{
	public UserNotFoundException(String s) {
		super(s);
	}
}

public class CustomExceptionMain {
	
	public static void main(String args[]){
		try {
			//encountered the situation where user is not found
			throw new UserNotFoundException("User Doesn't Exist In the System");	
		}
		catch(UserNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
