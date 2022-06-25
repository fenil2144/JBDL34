
public class MethodOverloading {
	
	public double sum(double x,double y) {
		return (x+y);
	}
	
	public double sum(double x,double y, double z) {
		return (x+y+z);
	}
	
	public int sum(int a,int x,int y, int z) {
		return (a+x+y+z);
	}
	
	public static void main(String args[]) {
		MethodOverloading methodOverloading = new MethodOverloading();
		System.out.println(methodOverloading.sum(2, 3));
		System.out.println(methodOverloading.sum(2.0, 3.0,4.0));
		System.out.println(methodOverloading.sum(2, 3,4,5));

	}
	
	public static void main(int a,int b) {
		
	}

}
