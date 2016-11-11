package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Curso {
	
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getAlunos() {
		return alunos;
	}

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		
		//cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		//Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);		
		//cursos.forEach(c -> System.out.println(c.getNome()));
		//streamDeCurso.forEach(c -> System.out.println(c.getNome()));
		
		//cursos.stream().filter(c -> c.getAlunos() > 100).forEach(c -> System.out.println(c.getNome()));
		//cursos.stream()
		   //.filter(c -> c.getAlunos() > 100)
		   //.forEach(c -> System.out.println(c.getNome()));
		
		//cursos.stream()
		   //.filter(c -> c.getAlunos() > 100)
		   //.map(c -> c.getAlunos())
		   //.forEach(x -> System.out.println(x));
		
		//cursos.stream()
		   //.filter(c -> c.getAlunos() > 100)
		   //.map(Curso::getAlunos)
		   //.forEach(System.out::println);

		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .sum();
		
		
		OptionalDouble media = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .average();
		
		
		//System.out.println(soma);

		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		
		cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.findAny()
				.ifPresent(c -> System.out.println(c.getNome()));
		
		
		Map mapa = cursos 
				.stream() 
				.filter(c -> c.getAlunos() > 100) 
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		
		//Curso curso =optionalCurso.orElse(null);
		//System.out.println(curso.getNome());
		
		List<Curso> resultado = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toList());
		
		//cursos = cursos.stream()
				//.filter(c -> c.getAlunos() >= 100)
				//.collect(Collectors.toList());
		
		cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toMap(
						c -> c.getNome(),
						c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos "));	
		
		
	}

}
