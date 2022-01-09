package tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		// PARA CRIAR O TABULEIRO, A QUANTIDADE
		// DE LINHAS OU COLUNAS PRECISA SER PELO MENOS UM
		
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroExceptions("Erro ao criar o tabuleiro, � necess�rio ter pelo menos 1 linha e uma coluna.");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	//METODO PARA RETORNAR A MATRIZ PE�A NA LINHA E COLUNA INFORMADA.
	public Peca peca(int linha, int coluna) {
		if(!posicaoExistente(linha, coluna)) {
			throw new TabuleiroExceptions("Posi��o fora do tabuleiro!");
		}
		return pecas[linha][coluna];
	}
	
	// METODO PARA RETORNAR A PE�A PELA POSI��O INFORMADA.
	public Peca peca(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new TabuleiroExceptions("Posi��o fora do tabuleiro!");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	// METODO RESPONS�VEL POR COLOCAR A PE�A INFORMADA NA POSI��O INFORMADA.
	
	public void alocarPeca(Peca peca, Posicao posicao) {
		if(temUmaPeca(posicao)) {
			throw new TabuleiroExceptions("Existe uma pe�a na posi��o " + posicao + ".");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	
	/* COMPLEMENTO DO PR�XIMO M�TODO, RETORNA UMA CONDI��O V OU F 
	   CASO A LINHA OU COLUNA INFORMADA SEJA DIFERENTE DO TAMANHO
	   DO TABULEIRO, RETORNAR� FALSO.		
	   
	   CONDI��O COMPLETA PARA SABER SE ESSA POSI��O EXISTE.
	*/
	private boolean posicaoExistente(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	// PEGA UMA POSI��O E INFORMA SE ESSA POSI��O EXISTE OU N�O.
	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}
	
	// METODO PARA SABER SE TEM UMA PE�A NA POSI��O INFORMADA.
	public boolean temUmaPeca(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new TabuleiroExceptions("Posi��o fora do tabuleiro!");
		}
		return peca(posicao) != null;
	}
}
