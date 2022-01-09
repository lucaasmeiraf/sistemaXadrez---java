package application;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// INSTACIAR UMA PARTIDA DE XADREZ
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		// USER INTERFACE(UI) METODO PARA IMPRIMIR O TABULEIRO E UMA PEÇA
		
		while (true) {
			UI.printTabuleiro(partidaXadrez.getPecas());
			System.out.println();
			System.out.print("Origem: ");
			PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
			System.out.println();
			System.out.println("Destino: ");
			PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
			
			PecaXadrez pecaCapturada = partidaXadrez.performMovimentoXadrez(origem, destino);
		}
	}

}
