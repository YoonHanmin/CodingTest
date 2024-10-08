package codingTest;

import java.util.Arrays;
import java.util.Arrays.*;
import java.util.List;

public class Stream {
	public static void main(String[] args) {
		String[] arr = new String[]{"a","b","c"};
		
		List<String> list = Arrays.asList("a","b","c");
		
		Stream stream = (Stream) list.stream();
		
	}
}
