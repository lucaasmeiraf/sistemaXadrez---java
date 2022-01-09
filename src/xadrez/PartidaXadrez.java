package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
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
	
	// MÉTODO DE MOVIMENTAÇÃO DO PONTO DE ORIGEM EO PONTO DESTINADO.
	public PecaXadrez performMovimentoXadrez(PosicaoXadrez origemPosicao, PosicaoXadrez destinoPosicao) {
		Posicao origem = origemPosicao.toPosicao();
		Posicao destino = destinoPosicao.toPosicao();
		validarPosicaoOrigem(origem);
		Peca pecaCapturada = facaMovimento(origem, destino);
		return (PecaXadrez)pecaCapturada;
	}
	
	// MÉTODO
	private Peca facaMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca pecaCapturada = tabuleiro.removerPeca(destino); 
		tabuleiro.alocarPeca(p, destino);
		return pecaCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.temUmaPeca(posicao)) {
			throw new XadrezException("Nao existe peca na posicao de origem.");
		}
		if(!tabuleiro.peca(posicao).temAlgumPossivelMovimento()) {
			throw new XadrezException("Nao existe moviemtos possiveis para a peca escolhida.");
		}
	}
	
	
	// OPERACAO DE COLOCAR PECA PASSANDO A POSIÇÃO NAS COORDENADAS DO XADREZ
	private void alocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.alocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	// METODO PARA SETAR O SETUP INICIAL DO TABULEIRO, POSIÇÃO INICIAL DAS PEÇAS
	private void setupInicial() {
		alocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		alocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		alocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		alocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		alocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		alocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		alocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		alocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		alocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		alocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		alocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		alocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}

}
