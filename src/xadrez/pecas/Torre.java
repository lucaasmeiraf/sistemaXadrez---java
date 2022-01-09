package xadrez.pecas;

import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}

	// toString RETORNA A LETRA DA PEÇA - T DE TORRE
	
	@Override 
	public String toString() {
		return "T";
	}
	
}
