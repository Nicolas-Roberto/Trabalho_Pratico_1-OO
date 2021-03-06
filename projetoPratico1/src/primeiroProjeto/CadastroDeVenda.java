package primeiroProjeto;

import java.util.Scanner;

public class CadastroDeVenda {
	// mostra lista de clientes e seleciona um deles
	public static int mostrarListaDeClientes(NovoCliente clientes[]) {
		
		String nome, end, tel; 
		int clienteSelecionado;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			for(int i = 0; i < clientes.length; i++) {
				nome = clientes[i].getNome();
				end = clientes[i].getEnd();
				tel = clientes[i].getTel();
				System.out.println("Cliente (" + (i+1) + ")\nNome: " + nome + "\nEndereço: " + end + "\nTelefone: " + tel + "\n");
			}
			System.out.println("Selecione um cliente pelo número: ");
			clienteSelecionado = sc.nextInt();
			clienteSelecionado--;
			if((clienteSelecionado) < 0 || (clienteSelecionado) >= clientes.length) {			
				System.out.println("Cliente invalido!\n");
				FuncoesGenericas.esperar();
			} else {
				return (clienteSelecionado);							
			}
			
		}
	}

	// mostra lista de produtos, e caso alterar seja true seleciona um produto
	public static int mostrarListaDeProdutos(NovoProduto produtos[], boolean alterar) {
		
		String nome, desc;
		float preco;
		int qtds;
		int produtoSelecionado;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			for(int i = 0; i < produtos.length; i++) {
				nome = produtos[i].getNome();
				desc = produtos[i].getDescricao();
				preco = produtos[i].getPreco();
				qtds = produtos[i].getQtdsEmEstoque();
				System.out.println("Produto (" + (i+1) + ")\nNome: " + nome + "\nDescrição: " + desc 
						+ "\nPreço: "+ preco +"\nQuantidade em Estoque: " + qtds + "\n");
			}
			if(alterar == true) {
				System.out.println("Selecione um produto pelo número: ");
				produtoSelecionado = sc.nextInt();
				produtoSelecionado--; 
				if((produtoSelecionado) < 0 || (produtoSelecionado) >= produtos.length) {			
					System.out.println("Produto invalido!\n");
					FuncoesGenericas.esperar();
				} else {
					return (produtoSelecionado);
				}
			} else {
				return 0;
			}
			
		}
	}
	
	// realiza uma compra 
	public static void comprar(NovoCliente clientes[], 
			int idCliente, NovoProduto produtos[], int idProduto) { 
		
		int unidades;
		int qtdsEmEstoque = produtos[idProduto].getQtdsEmEstoque();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Em estoque: " + qtdsEmEstoque);
		System.out.println("Quantos unidades deseja comprar ? ");
		unidades = sc.nextInt();
		
		produtos[idProduto].comprar(unidades);
		FuncoesGenericas.esperar();
	}
}
