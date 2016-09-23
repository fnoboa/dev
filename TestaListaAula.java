package br.com.caelum.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaAula {
	public static void main(String[] args) {
		
		
		Aula a1 = new Aula(null, 21);
		Aula a2 = new Aula("Listas de objetos", 20);
        Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
		
        ArrayList<Aula> aulas = new ArrayList<>();
        aulas.add(a1);
        aulas.add(a2);
        aulas.add(a3);
        
        // antes de ordenar:
        System.out.println(aulas);

        //Collections.sort(aulas);
        aulas.sort(Comparator.comparing(Aula::getTempo));

        // depois de ordenar:
        System.out.println(aulas);
        
        
        
        
	}
}
