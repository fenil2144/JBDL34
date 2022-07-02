package Class3;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {

	public static void main(String args[]) {
		
		List<String> list = Arrays.asList("FENIL", "H","E","E","L","O","G","K");
		
		list.parallelStream().forEach(System.out::print);
		//OLGFENILEEHK
		//OLEKFENILGEH
		
		System.out.println(" AVLBL Processors "+Runtime.getRuntime().availableProcessors());
	}
}
