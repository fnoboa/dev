package javaSamples;

import java.util.Scanner;

public class Dados10 {
	
	final static int SUCESSO = 0;
	final static int LISTA_CHEIA_DIREITA = 1;
	final static int LISTA_CHEIA_ESQUERDA = 2;
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		String s;
		final int m = 7;
		int [] v = new int[m + 2];   // v[0] = inic e v[m] = fim
		int valor;
		int erro = SUCESSO;
		char ch = 'A';
		
		criaLista(v);
		
		do {
			exibeLista(v);
			System.out.printf("\nValor: ");
			s = entrada.nextLine();
			valor = Integer.parseInt(s);
			
			if (valor != 0) {
				System.out.printf("[I]nicio ou [F]im ?");
				do {
					s = entrada.nextLine();
					ch = s.charAt(0);					
				} while (ch != 'I' && ch !='i' && ch != 'F' && ch != 'f');
			}
			switch (ch) {
			   case 'I':
			   case 'i': erro = incluiInicio(v, valor);
			      break;
			   case 'F':
			   case 'f': erro = incluiFim(v, valor);
			      break;
			}
			if (erro != SUCESSO) {
				imprimeErro(erro);
			}
		} while (valor != 0);
		exibeLista(v);
		System.exit(0);
				
	}

	private static void imprimeErro(int erro) {
		switch (erro) {
		
		   case LISTA_CHEIA_ESQUERDA: System.out.println("ERRO: Lista Cheia à Esquerda");
		      break;
		   case LISTA_CHEIA_DIREITA: System.out.println("ERRO: Lista Cheia à Direita");
		      break;
		}
		
	}

	private static int incluiFim(int[] v, int dado) {
		int inic = v[0];
		int fim = v[v.length -1];
		int m = v.length - 2;
		int metade = (m / 2) + 1;
		
		if (fim == -1) {
			inic = metade;
			fim = inic;
			v[fim] = dado;
			v[0] = inic;
			v[v.length - 1] = fim;
			return (SUCESSO);			
		} else {
			if (fim == m) {
				return (LISTA_CHEIA_DIREITA);
			}
			else {
				fim++;
				v[fim] = dado;
				v[v.length - 1] = fim;
				return (SUCESSO);
			}
		}
		
		
	}

	private static int incluiInicio(int[] v, int dado) {
		int inic = v[0];
		int fim = v[v.length -1];
		int m = v.length - 2;
		int metade = (m / 2) +1;
		
		if (inic == -1) {
			inic = metade;
			fim = inic;
			v[inic] = dado;
			v[0] = inic;
			v[v.length - 1] = fim;
			return (SUCESSO);
		} 
		else {
			if (inic == 1) {
				return (LISTA_CHEIA_ESQUERDA);
			}
			else {
				inic--;
				v[inic] = dado;
				v[0] = inic;
				return (SUCESSO);
			}
		}		
	
	}

	private static void exibeLista(int[] v) {
		
		int inic = v[0];
		int fim = v[v.length - 1];
		
		System.out.println("inic: " + inic);
		System.out.println("fim: " + fim);
		System.out.printf("indices: ");
		for (int i = 0; i < v.length; i++) {
			System.out.printf("%2d " , i);			
		}
		System.out.println();
		System.out.printf("Lista: ");
		for (int i = 0; i < v.length; i++) {
			System.out.printf("%2d " , v[i]);			
		}
		
	}

	//cria lista
	private static void criaLista(int[] v) {
		int inic = 0;
		int fim =v.length -1;
		
		v[inic] = -1;
		v[fim] = -1;
		
	}
	
	

}
