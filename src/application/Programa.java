package application;

import tabuleiro.Tabuleiro;
import xadrez.PartidaXadrez;

public class Programa {

	public static void main(String[] args) {
		
		// INSTACIAR UMA PARTIDA DE XADREZ
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		// USER INTERFACE(UI) METODO PARA IMPRIMIR O TABULEIRO E UMA PEÇA
		UI.printTabuleiro(partidaXadrez.getPecas());
		
	}

}
