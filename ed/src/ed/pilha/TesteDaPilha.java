package ed.pilha;

import java.util.Stack;

public class TesteDaPilha {
	
	public static void main(String[] args) {
		/*Pilha pilha = new Pilha();
		
		pilha.insere("Mauricio");
		System.out.println(pilha);

		pilha.insere("Guilherme");
		System.out.println(pilha);
		
		String r1 = pilha.remove();
		System.out.println(r1);

		String r2 = pilha.remove();
		System.out.println(r2);

		System.out.println(pilha);*/
		
		Stack<String> stack = new Stack<String>();
		stack.push("Mauricio");
		stack.push("Marcelo");
		
		System.out.println(stack);
		
		stack.pop();
		System.out.println(stack);
		
		String nome = stack.peek();
		System.out.println(nome);
		
	}

}
