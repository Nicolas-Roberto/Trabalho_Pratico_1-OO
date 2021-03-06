package primeiroProjeto;

import java.util.Scanner;

public class CadastrarNovoCliente {
	public static NovoCliente[] cadastrarClientes(NovoCliente totalClientes[]) {
		
		String nome, end, tel;
		
		int qtdsClientes = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantidade de clientes que deseja cadastrar:");
		try {
		qtdsClientes = sc.nextInt();
		} catch(Exception e) {
			System.out.println("Comando Invalido");
			FuncoesGenericas.esperar(); 
		}
		// verifica se ja ha clientes cadastrados e adiciona todos os clientes a um array vazio	
		if(totalClientes == null) {
			NovoCliente clientes[] = new NovoCliente[qtdsClientes];
				
			for(int i = 0; i < qtdsClientes ; i++) {
				clientes[i] = new NovoCliente();
			
				System.out.println("Nome do cliente " + (i+1) + ":\n");
				nome = sc.nextLine();
				clientes[i].setNome(nome);
				FuncoesGenericas.clearBuffer(sc);
				System.out.println("Endereço do cliente " + (i+1) + ":\n");
				end = sc.nextLine();
				clientes[i].setEnd(end);
				System.out.println("Telefone do cliente " + (i+1) + ":\n");
				tel = sc.nextLine();
				clientes[i].setTel(tel);	
				
			}
			return clientes;
		} else {
			qtdsClientes += totalClientes.length;
			NovoCliente clientes[] = new NovoCliente[qtdsClientes];
			
			for(int i = 0; i < totalClientes.length; i++) {
				clientes[i] = totalClientes[i];				
			}
			
			for(int i = totalClientes.length; i < qtdsClientes; i++) {
				clientes[i] = new NovoCliente();
			
				System.out.println("Nome do cliente " + (i+1) + ":\n");
				sc.nextLine();
				nome = sc.nextLine();
				clientes[i].setNome(nome);
				System.out.println("Endereço do cliente " + (i+1) + ":\n");
				sc.nextLine();
				end = sc.nextLine();
				clientes[i].setEnd(end);
				System.out.println("Telefone do cliente " + (i+1) + ":\n");
				sc.nextLine();
				tel = sc.nextLine();
				clientes[i].setTel(tel);	
			}
			return clientes;
		}
	}
}
