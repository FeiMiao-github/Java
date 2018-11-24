package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class MethodReference {
	static String[] string = {"abcd", "abc", "ab", "a"};
	public static void main(String[] args) {
		
		List<String> characterList = Arrays.asList(string);
		characterList.forEach((character) -> System.out.println(character));	
	}
	
	@Test
	public void test() {
		// List<String> list = Arrays.asList(string);
		List<String> stringList = new ArrayList<>();
		for (String s: string) {
			stringList.add(s);
		}
		Iterator<String> it = stringList.iterator();
		while(it.hasNext()) {
			String player = it.next();
			if (player.equals("abc")) it.remove();
		}
		stringList.forEach(s -> System.out.println(s));
		System.out.println("======================");
		
		stringList.removeIf(new Predicate<String>() {
			public boolean test(String player) {
				return player.equals("a");
			}
		});
		stringList.forEach(s -> System.out.println(s));
		System.out.println("======================");
		
		stringList.removeIf((s) -> s.equals("ab"));
		stringList.forEach(s -> System.out.println(s));
	}
	
}
