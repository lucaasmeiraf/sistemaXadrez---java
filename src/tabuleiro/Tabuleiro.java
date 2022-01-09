package tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	//METODO PARA RETORNAR A MATRIZ PE�A NA LINHA E COLUNA INFORMADA
	public Peca peca(int linha, int coluna) {
		return pecas[linha][coluna];
	}
	
	// METODO PARA RETORNAR A PE�A PELA POSI��O INFORMADA
	public Peca peca(Posicao posicao) {
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	// METODO RESPONS�VEL POR COLOCAR A PE�A INFORMADA NA POSI��O INFORMADA.
	
	public void alocarPeca(Peca peca, Posicao posicao) {
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
}
