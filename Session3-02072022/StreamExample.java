package Class3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
	
	public static void main(String args[] ){
		
		List<Integer> number = Arrays.asList(2,3,4,5);
		
		System.out.println(number.stream().map(x -> x*x).collect(Collectors.toList()));
		System.out.println(number);
		
		
		
		List<String> names = Arrays.asList("Fenil","Shah","Geeks","GoKart");
		List<String> result = names.stream().filter(s-> s.startsWith("G")).collect(Collectors.toList());
		
		System.out.println(result);
		
		System.out.println(names.stream().sorted().collect(Collectors.toSet()));
		
		System.out.println(number.stream().filter(x -> x%2 == 0).reduce(10,(ans,i) -> ans+i));
		
		names.stream()
		.filter(p -> p.startsWith("G") && p.length()>5)
		.map(p -> p.toUpperCase())
		.sorted()
		.forEach(p -> System.out.println(p));
		
		//takeWhile - 
		Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
		.takeWhile(x -> x<=5)
		.forEach(System.out::print);
		
		
		
	}

}
