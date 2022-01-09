package xadrez;

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {

	//SUBCLASSE DA CLASSE PE�A
	
	private Cor cor;

	
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		//SUPER REPASSA A CHAMADA PARA O CONSTRUTOR Tabuleiro() DA CLASSE PE�A.
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	
	
}
