
class Dog {
	
	private String name;
	private String breed;
	private String color;
	
//	public Dog() {
//		
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Dog(String name, String breed, String color) {
		this.name = name;
		this.breed = breed;
		this.color = color;
	}
	
	public String toString() {
		return "Dog [name=" + name + ", breed=" + breed + ", color=" + color + "]";
	}

	
	public static void main(String args[]) {

		Dog tuffy = new Dog("tuffy","papillon","White");
		System.out.println(tuffy.toString());
		
	}





}
