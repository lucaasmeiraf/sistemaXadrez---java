package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	//CLASSE DE REGRAS DO JOGO DE XADREZ
	
	private Tabuleiro tabuleiro;

	//CONSTRUTOR PADRÃO DIZENDO QUE TABULEIRO RECEBE UMA INSTANCIA DO TABULEIRO COM SEU TAMANHA(8, 8)
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		setupInicial();
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
	
	// OPERACAO DE COLOCAR PECA PASSANDO A POSIÇÃO NAS COORDENADAS DO XADREZ
	private void alocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.alocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	// METODO PARA SETAR O SETUP INICIAL DO TABULEIRO, POSIÇÃO INICIAL DAS PEÇAS
	private void setupInicial() {
		alocarNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		alocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		alocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
	}

}
