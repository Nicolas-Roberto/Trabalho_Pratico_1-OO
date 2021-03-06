package primeiroProjeto;

import java.util.Scanner;

public class CadastrarNovoProduto {
	public static NovoProduto[] cadastrarNovosProdutos(NovoProduto totalProdutos[]) {
			
			String nome, desc;
			float preco = 0;
			int qtdsEmEstoque = 0;
			int qtdsProdutos = 0;
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Quantidade de produtos que deseja cadastrar:");
			try {
			qtdsProdutos = sc.nextInt();
			} catch(Exception e) {
				System.out.println("Comando Invalido");
				FuncoesGenericas.esperar(); 
			}
			// verifica se ja ha produtos cadastrados e adiciona todos os produtos a um array vazio	
			if(totalProdutos == null) {
				NovoProduto produtos[] = new NovoProduto[qtdsProdutos];
				
				for(int i = 0; i < qtdsProdutos; i++) {
					produtos[i] = new NovoProduto();
					
					System.out.println("Nome do produto: " + (i+1) + ":");
					nome = sc.nextLine();
					produtos[i].setNome(nome);
					FuncoesGenericas.clearBuffer(sc);
					System.out.println("Descrição do produto " + (i+1) + ":");
					desc = sc.nextLine();
					produtos[i].setDescricao(desc);
					System.out.println("Valor do produto " + (i+1) + ":");
					preco = sc.nextFloat();
					produtos[i].setPreco(preco);
					System.out.println("Quantidade disponivel: " );
					qtdsEmEstoque = sc.nextInt();
					produtos[i].setQtdsEmEstoque(qtdsEmEstoque);
				}
				
				return produtos;	
				
			} else {
				qtdsProdutos += totalProdutos.length;
				NovoProduto produtos[] = new NovoProduto[qtdsProdutos];
				
				for(int i = 0; i < totalProdutos.length; i++) {
					produtos[i] = totalProdutos[i];				
				}

				for(int i = totalProdutos.length; i < qtdsProdutos; i++) {
					produtos[i] = new NovoProduto();
					
					System.out.println("Nome do produto: " + (i+1) + ":");
					nome = sc.next();
					produtos[i].setNome(nome);
					System.out.println("Descrição do produto " + (i+1) + ":");
					desc = sc.next();
					produtos[i].setDescricao(desc);
					System.out.println("Valor do produto " + (i+1) + ":");
					preco = sc.nextFloat();
					produtos[i].setPreco(preco);
					System.out.println("Quantidade disponivel: " );
					qtdsEmEstoque = sc.nextInt();
					produtos[i].setQtdsEmEstoque(qtdsEmEstoque);
				}
				
				
				return produtos;	
			}
			
		}
}
