package tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		// PARA CRIAR O TABULEIRO, A QUANTIDADE
		// DE LINHAS OU COLUNAS PRECISA SER PELO MENOS UM
		
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroExceptions("Erro ao criar o tabuleiro, é necessário ter pelo menos 1 linha e uma coluna.");
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
	
	//METODO PARA RETORNAR A MATRIZ PEÇA NA LINHA E COLUNA INFORMADA.
	public Peca peca(int linha, int coluna) {
		if(!posicaoExistente(linha, coluna)) {
			throw new TabuleiroExceptions("Posição fora do tabuleiro!");
		}
		return pecas[linha][coluna];
	}
	
	// METODO PARA RETORNAR A PEÇA PELA POSIÇÃO INFORMADA.
	public Peca peca(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new TabuleiroExceptions("Posição fora do tabuleiro!");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	// METODO RESPONSÁVEL POR COLOCAR A PEÇA INFORMADA NA POSIÇÃO INFORMADA.
	
	public void alocarPeca(Peca peca, Posicao posicao) {
		if(temUmaPeca(posicao)) {
			throw new TabuleiroExceptions("Existe uma peça na posição " + posicao + ".");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	
	/* COMPLEMENTO DO PRÓXIMO MÉTODO, RETORNA UMA CONDIÇÃO V OU F 
	   CASO A LINHA OU COLUNA INFORMADA SEJA DIFERENTE DO TAMANHO
	   DO TABULEIRO, RETORNARÁ FALSO.		
	   
	   CONDIÇÃO COMPLETA PARA SABER SE ESSA POSIÇÃO EXISTE.
	*/
	private boolean posicaoExistente(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	// PEGA UMA POSIÇÃO E INFORMA SE ESSA POSIÇÃO EXISTE OU NÃO.
	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}
	
	// METODO PARA SABER SE TEM UMA PEÇA NA POSIÇÃO INFORMADA.
	public boolean temUmaPeca(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new TabuleiroExceptions("Posição fora do tabuleiro!");
		}
		return peca(posicao) != null;
	}
}
