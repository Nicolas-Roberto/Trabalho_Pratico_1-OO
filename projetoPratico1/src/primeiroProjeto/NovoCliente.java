package primeiroProjeto;


public class NovoCliente { // objeto cliente
	private String nome;
	private String end;
	private String tel;
	
	public NovoCliente() {
		nome = "cliente inexistente";
		end = "cliente inexistente";
		tel = "cliente inexistente";
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}
	public String getEnd() {
		return end;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;
	}
	
}
