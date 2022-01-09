package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	//CLASSE DE REGRAS DO JOGO DE XADREZ
	
	private Tabuleiro tabuleiro;

	//CONSTRUTOR PADR�O DIZENDO QUE TABULEIRO RECEBE UMA INSTANCIA DO TABULEIRO COM SEU TAMANHA(8, 8)
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		setupInicial();
	}

	//M�TODO PARA RETORNAR UMA MATRIZ DE PE�AS DE XADREZ CORRESPONDENTE � ESSA PARTIDA
	public PecaXadrez[][] getPecas() {
		
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	// METODO PARA SETAR O SETUP INICIAL DO TABULEIRO, POSI��O INICIAL DAS PE�AS
	private void setupInicial() {
		tabuleiro.alocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));
		tabuleiro.alocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
		tabuleiro.alocarPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 4));
	}

}
