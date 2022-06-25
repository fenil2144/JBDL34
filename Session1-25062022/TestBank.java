abstract class Bank{
	abstract int getROI();
	abstract void deposit(double depositAmount);
	double withdraw() {
		return 0;
		
	}
}

class SBI extends Bank{
	int getROI() {
		return 6;
	}

	@Override
	void deposit(double depositAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	double withdraw() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class PNB extends Bank{
	int getROI() {
		return 7;
	}

	@Override
	void deposit(double depositAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	double withdraw() {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class TestBank {
	
	public static void main(String args[]) {
		
		Bank b;
		b = new SBI();
		System.out.println("SBI "+b.withdraw());
		b= new PNB();
		System.out.println("PNB "+b.getROI());
	}

}
