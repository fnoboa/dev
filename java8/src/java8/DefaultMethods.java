package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethods {

	public static void main(String[] args) {	
	
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do código");
		palavras.add("caelum");
		
		palavras.forEach(s -> System.out.println(s));
		
		//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		//palavras.sort(Comparator.comparing(s -> s.length()));
		
		palavras.sort(Comparator.comparing(String::length));
		
		//palavras.sort(comparing(String::length));
		
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
		//palavras.forEach(s -> System.out.println(s));
		
		palavras.forEach(System.out::println);
			
	}

}
