package Class3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Developer{
	
	String name;
	BigDecimal Salary;
	int age;
	
	public Developer(String name, BigDecimal salary, int age) {
		super();
		this.name = name;
		Salary = salary;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalary() {
		return Salary;
	}
	public void setSalary(BigDecimal salary) {
		Salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Developer [name=" + name + ", Salary=" + Salary + ", age=" + age + "]";
	}
	
}

public class CompareToExample {
	
	public static void main(String[] args) {
		
		List<Developer> listDevs = new ArrayList<Developer>();
		
		listDevs.add(new Developer("ketan",new BigDecimal("70000"),22));
		listDevs.add(new Developer("alvin",new BigDecimal("80000"),32));
		listDevs.add(new Developer("iris",new BigDecimal("65000"),12));
		listDevs.add(new Developer("jason",new BigDecimal("170000"),24));
		
		System.out.println("Before"+ listDevs);
		
		Collections.sort(listDevs, new Comparator<Developer>() {

			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		
		listDevs.sort((o1,o2) -> o1.getName().compareTo(o2.getName()));
//		for(Developer developer : listDevs) {
//			System.out.println(developer);
//		}
		
		listDevs.forEach((developer) -> System.out.println(developer));

		
	}

}
