package primeiroProjeto;

public class NovoProduto { // objeto produto
	private String nome;
	private String descricao;
	private float preco;
	private int qtdsEmEstoque;
	
	public NovoProduto() {
		nome = "Produto inexistente";
		qtdsEmEstoque = 0;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public int getQtdsEmEstoque() {
		return qtdsEmEstoque;
	}
	public void setQtdsEmEstoque(int qtdsEmEstoque) {
		this.qtdsEmEstoque = qtdsEmEstoque;
	}
	
	public void comprar(int qtds) {
		if(( this.qtdsEmEstoque - qtds ) < 0  ) {
			System.out.println("Não há tantos produtos em estoque!");
			System.out.println("Temos: " + this.qtdsEmEstoque);
		} else {
			this.qtdsEmEstoque = (this.qtdsEmEstoque - qtds);
		}
	}
	

}
