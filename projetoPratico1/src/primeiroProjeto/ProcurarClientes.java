package primeiroProjeto;

import java.util.Scanner;

public class ProcurarClientes {
	public static void procurarCliente(NovoCliente clientes[]) {
		// busca um cliente pelo nome
		Scanner sc = new Scanner(System.in);
		
		String nome, end = null, tel = null;
		
		System.out.println("Digite o nome do cliente a ser procurado:");
		nome = sc.next();
		
		for(int i = 0; i < clientes.length; i++) {
			if(nome.equals(clientes[i].getNome())) {
				end = clientes[i].getEnd();
				tel = clientes[i].getTel();
				if(tel != null) {
					System.out.println("Nome: " + nome + "\nEndereço: " + end + "\nTelefone: " + tel + "\n");
				} else {
					System.out.println("Cliente nâo encontrado");
				}
			}
		}	
		FuncoesGenericas.esperar();			
	}
}
