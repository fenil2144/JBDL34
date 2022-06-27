package Class2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapExample {
	public static void main(String args[]) {
		HashMap<Integer, String> phoneDirectory = new HashMap<Integer, String>();
		phoneDirectory.put(123456, "Fenil");
		phoneDirectory.put(3453122, "Amitendra");
		phoneDirectory.put(1334343, "Gulshan");
		
		System.out.println(phoneDirectory);
		
		for(Integer phone : phoneDirectory.keySet()) {
			System.out.println(phone);
		}
		
		for(String name : phoneDirectory.values()) {
			System.out.println(name);
		}
		
		for(Entry<Integer, String> entry : phoneDirectory.entrySet() ) {
			System.out.println(entry);
		}
		
		phoneDirectory.entrySet().stream()
		.sorted(Map.Entry.comparingByKey()).forEach(System.out :: print);

	}
}
