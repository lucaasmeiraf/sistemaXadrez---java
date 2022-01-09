package xadrez;

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {

	//SUBCLASSE DA CLASSE PEÇA
	
	private Cor cor;

	
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		//SUPER REPASSA A CHAMADA PARA O CONSTRUTOR Tabuleiro() DA CLASSE PEÇA.
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	
	
}
