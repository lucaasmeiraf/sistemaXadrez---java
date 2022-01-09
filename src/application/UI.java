package application;

import xadrez.PecaXadrez;

public class UI {

	//M�TODO PARA IMPRIMIR O TABULEIRO COM LINHAS E COLUNAS
	public static void printTabuleiro(PecaXadrez[][] pecas) {
		
		for(int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j = 0; j < pecas.length; j++) {
				printPeca(pecas[i][j]);
				
			}
			System.out.println();
		}
		
		System.out.println("  a b c d e f g h");
		
	}
	
	//M�TODO PARA IMPRIMIR SOMENTE UMA PE�A
	private static void printPeca(PecaXadrez peca) {
		if(peca == null) {
			System.out.print("-");
		}else {
			System.out.print(peca);
			
		}
		System.out.print(" ");
	}
	
}
