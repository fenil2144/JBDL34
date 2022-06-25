class cat{
	public void eat() {
		System.out.println("Cat");
	}
}

interface dog1{
	public void eat();
}
interface dog2{
	void eat();
}

public class MultipleInheritance extends cat implements dog1,dog2{

	public void eat() {
		System.out.println("Cat");
	}
}

