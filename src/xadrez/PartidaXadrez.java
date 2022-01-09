package xadrez;

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public class PartidaXadrez {

	//CLASSE DE REGRAS DO JOGO DE XADREZ
	
	private Tabuleiro tabuleiro;

	//CONSTRUTOR PADRÃO DIZENDO QUE TABULEIRO RECEBE UMA INSTANCIA DO TABULEIRO COM SEU TAMANHA(8, 8)
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
	}

	//MÉTODO PARA RETORNAR UMA MATRIZ DE PEÇAS DE XADREZ CORRESPONDENTE À ESSA PARTIDA
	public PecaXadrez[][] getPecas() {
		
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}

}
