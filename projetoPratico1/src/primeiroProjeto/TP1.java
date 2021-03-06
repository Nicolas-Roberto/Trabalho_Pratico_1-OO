package primeiroProjeto;

import java.io.IOException;
import java.util.Scanner;



public class TP1 {	
	public static void main(String[] args) throws IOException {
    
		Scanner sc = new Scanner(System.in);
		// variaveis 
		NovoCliente clientes[] = null;
		NovoProduto produtos[] = null;
		int idComprador;
		int idProduto;
		boolean sair = false;
		boolean comprarDnv = true;
		String comando;
		
		clientes = CadastroAutomatico.cadastrarClientesAuto(); // cadastra 10 clientes
		produtos = CadastroAutomatico.cadastrarProdutosAuto(); // cadastra 10 produtos

		do {
			FuncoesGenericas.menu(); //menu
			
			comando = sc.next(); // seleciona uma função
			
			FuncoesGenericas.clear(); //(limpa) o terminal
			
			switch (comando) {
				case "1": { 
					clientes = CadastrarNovoCliente.cadastrarClientes(clientes); //cadastra novo cliente							
					break;
				}
				case "2": {
					if(!(FuncoesGenericas.verificar(clientes, produtos))) { // (verifica) se ja há clientes cadastrados
						ProcurarClientes.procurarCliente(clientes); // procura um cliente pelo nome
					}
					break;
				}
				case "3": {
					produtos = CadastrarNovoProduto.cadastrarNovosProdutos(produtos); // cadastra novo produto
					break;
				}
				case "4":{
					if(!(FuncoesGenericas.verificar(clientes, produtos))) { 
						ProcurarProdutos.procurarProduto(produtos); // procura um produto por nome						
					}
					break;
				}
				case "5":{
					if(!(FuncoesGenericas.verificar(clientes, produtos))) { 
						do {
							FuncoesGenericas.clear();
							idComprador = CadastroDeVenda.mostrarListaDeClientes(clientes); // mostra todos os clientes e seleciona um deles
							FuncoesGenericas.esperar();// espera o usuario digitar algo para continuar
							FuncoesGenericas.clear();
							idProduto = CadastroDeVenda.mostrarListaDeProdutos(produtos, true); // mostra todos os produtos e seleciona um deles
							FuncoesGenericas.esperar();
							FuncoesGenericas.clear();
							CadastroDeVenda.comprar(clientes, idComprador, produtos, idProduto); // realiza uma compra 
							FuncoesGenericas.clear();
							
							System.out.println("Deseja realizar outra compra? (s/n)"); // opcao de continuar o loop
							if(sc.next().charAt(0) == 'n') {
								comprarDnv = false; 
							}
						} while(comprarDnv); // loop de compra
					}
					break;
				}
				case "6":{
					if(!(FuncoesGenericas.verificar(clientes, produtos))) {
						CadastroDeVenda.mostrarListaDeProdutos(produtos, false); // mostra lista de produtos 
						FuncoesGenericas.esperar();
					}
					break;
				}
				case "7": sair = true; break; // encerra o programa
				
				default: { // digitos inesperados
					System.out.println("Comando Inválido!!!"); 
					FuncoesGenericas.esperar();
				}
					
			};
		} while(sair == false); // loop do menu
		sc.close(); // fecha o scanner
	}
}