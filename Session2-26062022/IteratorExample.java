package Class2;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

	public static void main(String args[]) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(2);
		
		System.out.println(numbers);
		
		Iterator<Integer> iteratorObj = numbers.iterator();
		
		System.out.println(iteratorObj.next());
		iteratorObj.remove();
		
		while(iteratorObj.hasNext()) {
//			System.out.println(iteratorObj.next());
			//(argument,argument2) -> {body}
			iteratorObj.forEachRemaining((value) -> System.out.println(value*2+" "));
		}
		
		for(Integer x: numbers) {
			System.out.print(x);
		}
		System.out.print(numbers);
		
	}
}
