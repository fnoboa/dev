package br.com.caelum.collections;

import java.util.List;

public class TestaCurso {
	
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		List<Aula> aulas = javaColecoes.getAulas();
		System.out.println(aulas);
		
		Aula teste = new Aula("Trabalhando com ArrayList", 21);
		
		//javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));	
		//javaColecoes.getAulas().add(teste);	
		
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
        
		System.out.println(javaColecoes.getAulas());
		
	}

}
