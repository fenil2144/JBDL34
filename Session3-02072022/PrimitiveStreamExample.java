package Class3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreamExample {

	public static void main(String args[]) {
		
		int[] integers = {1,2,3,4,5,6};
		
		IntStream intStream = Arrays.stream(integers);
		
		System.out.println(intStream.min().getAsInt());
		
		System.out.println(IntStream.of(1,2,3,4,5).sum());
		
		//Primitive Stream to List
		List<Integer> listOfIntegers = IntStream.of(1,2,3,4,5)
		.boxed()
		.collect(Collectors.toList());
		
		List<Double> db = DoubleStream.of(1.0,2.0,3.0,4.0,5.0)
		.mapToObj(Double::valueOf)
		.collect(Collectors.toList());
		
		System.out.println(db);
		
		System.out.println(listOfIntegers);
		
		//Primitive Stream to Arrays
		IntStream.of(1,2,3,4,5).toArray();
		
		
		
	}
}
