package primeiroProjeto;

import java.util.Scanner;

	public class ProcurarProdutos {
		public static void procurarProduto(NovoProduto produtos[]) {
			// busca um produto pelo nome
			Scanner sc = new Scanner(System.in);
			
				String nome, desc = null;
				float preco;
				int qtdsEmEstoque;
				
				System.out.println("Digite o nome do produto a ser procurado:");
				nome = sc.next();
				
				for(int i = 0; i < produtos.length; i++) {
					if(nome.equals(produtos[i].getNome())) {
						desc = produtos[i].getDescricao();
						preco = produtos[i].getPreco();
						qtdsEmEstoque = produtos[i].getQtdsEmEstoque();
						if(desc != null) {
							System.out.println("Nome: " + nome + "\nDescrição: "
									+ desc + "\nPreço: " + preco + "\nQuantidades em estoque: "
									+ qtdsEmEstoque + "\n");
						} else {
							System.out.println("Cliente nâo encontrado");
						}
					}
				}	
			
			System.out.println("\nDigite 0 para continuar:");
			sc.next();
						
		}
}
