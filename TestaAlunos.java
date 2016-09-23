package br.com.caelum.collections;

import java.util.Collection;
import java.util.HashSet;

public class TestaAlunos {

	public static void main(String[] args) {
		
		Collection<String> alunos = new HashSet<>();
		
		alunos.add("Rodrigo Turini");
        alunos.add("Alberto Souza");
        alunos.add("Paulo Silveira");
        alunos.add("Sergio Lopes");
        alunos.add("Renan Saggio");
        alunos.add("Mauricio Aniche");
        
        boolean pauloEstaMatriculado = alunos.contains("Paulo Silveira");
        
        System.out.println(pauloEstaMatriculado);
        
        System.out.println(alunos.size());
        
        for (String aluno : alunos) {
			System.out.println(aluno);
		}

        System.out.println(alunos);

        
	}
}
