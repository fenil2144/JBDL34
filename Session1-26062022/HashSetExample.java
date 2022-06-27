package Class2;

import java.util.HashSet;

public class HashSetExample {
	
	public static void main(String args[]) {
		HashSet<Integer> evenNumbers = new HashSet<Integer>();
		evenNumbers.add(2);
		evenNumbers.add(4);
		System.out.println("evenNumbers "+ evenNumbers);
		
		HashSet<Integer> numbers = new HashSet<Integer>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(4);
		System.out.println("numbers "+ numbers);
//		
//		numbers.addAll(evenNumbers);
//		System.out.println(numbers);
		
		//intersection opn
		numbers.retainAll(evenNumbers);
		
		System.out.println(numbers);

	}

}
