package primeiroProjeto;

import java.io.IOException;
import java.util.Scanner;



public class TP1 {	
	public static void main(String[] args) throws IOException {
    
		Scanner sc = new Scanner(System.in);
		
		NovoCliente clientes[] = null;
		NovoProduto produtos[] = null;
		int idComprador;
		int idProduto;
		boolean sair = false;
		boolean comprarDnv = true;
		String comando;

		do {
			System.out.println("----------------------------------");
			System.out.println("1. Cadastro de novo cliente. ");
			System.out.println("2. Busca por cliente. ");
			System.out.println("3. Cadastro de novo produto. ");
			System.out.println("4. Busca por produto. ");
			System.out.println("5. Cadastro de venda. ");
			System.out.println("6. Mostrar produtos em estoque. ");
			System.out.println("7. Sair. ");
			System.out.print("\nEscolha um comando: ");
			
			comando = sc.next();
			
			FuncoesGenericas.clear();
			
			switch (comando) {
				case "1": { 
					clientes = CadastrarNovoCliente.cadastrarClientes(clientes); 								
					break;
				}
				case "2": {
					if(!(FuncoesGenericas.verificar(clientes, produtos))) {
						ProcurarClientes.procurarCliente(clientes);
					}
					break;
				}
				case "3": {
					produtos = CadastrarNovoProduto.cadastrarNovosProdutos(produtos);
					break;
				}
				case "4":{
					if(!(FuncoesGenericas.verificar(clientes, produtos))) {
						ProcurarProdutos.procurarProduto(produtos);						
					}
					break;
				}
				case "5":{
					if(!(FuncoesGenericas.verificar(clientes, produtos))) {
						do {
							FuncoesGenericas.clear();
							idComprador = CadastroDeVenda.mostrarListaDeClientes(clientes);	
							FuncoesGenericas.esperar();
							FuncoesGenericas.clear();
							idProduto = CadastroDeVenda.mostrarListaDeProdutos(produtos, true);
							FuncoesGenericas.esperar();
							FuncoesGenericas.clear();
							CadastroDeVenda.comprar(clientes, idComprador, produtos, idProduto);
							FuncoesGenericas.clear();
							
							System.out.println("Deseja realizar outra compra? (s/n)");
							if(sc.next().charAt(0) == 'n') comprarDnv = false;
						} while(comprarDnv);
					}
					break;
				}
				case "6":{
					if(!(FuncoesGenericas.verificar(clientes, produtos))) {
						CadastroDeVenda.mostrarListaDeProdutos(produtos, false);
						FuncoesGenericas.esperar();
					}
					break;
				}
				case "7": sair = true; break;
				
				default: {
					System.out.println("Comando Inválido!!!");
					FuncoesGenericas.esperar();
				}
					
			};
		} while(sair == false);
		sc.close();
	}
}