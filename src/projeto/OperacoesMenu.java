package projeto;

import java.util.Scanner;

public class OperacoesMenu {
		
	public void menu() {
		System.out.println("OLÁ CLIENTE, PARA COMEÇAR, SELECIONE A OPÇÃO: ");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Criar conta");
		System.out.println("3 - Fechar conta");
		System.out.println("4 - Atualizar endereço");
		System.out.println("5 - Atualizar telefone");
		System.out.println("6 - Atualizar email");
		System.out.println("7 - Atualizar renda");
		System.out.println("8 - Verificar saldo");
		System.out.println("9 - Realizar depósito (Corrente ou Poupança)");
		System.out.println("10 - Realizar saque (Corrente ou Poupança)");
		System.out.println("11 - Calcular juros acumulados (Poupança ou Investimento)");
		System.out.println("12 - Investir (Investimento)");
		System.out.println("13 - Resgatar (Investimento)");
		System.out.println("14 - Imprimir lista de clientes)");
		System.out.println("0 - FINALIZAR OPERAÇÕES");
	}
	
	public int selecaoID (Conta [] listaConta, Scanner sc) {
		
		for (int i = 0; i< listaConta.length; i++) {
			
			if (listaConta[i] != null) {
				System.out.println("ID CLIENTE: " + listaConta[i].getID() + " | NOME CLIENTE: " + listaConta[i].titular.getNome());           
			}
		}
		
		System.out.println("Digite o ID do cliente: ");	
		int idSelecionado = sc.nextInt();
		
		idSelecionado --;
		
		while (listaConta[idSelecionado].getID() != idSelecionado+1) {
			
			System.out.println("ID INVÁLIDO! Digite um novo valor: ");	
			idSelecionado = sc.nextInt();
			
			idSelecionado --;		
		}
		return idSelecionado;
	}
	
	
	public void imprimirListaCLientes (Conta [] listaConta) {
		for(int i = 0; i < listaConta.length; i++) {		
			if (listaConta[i] != null) {
				listaConta[i].titular.imprimirCliente();
				System.out.println();           
			}							
		}		
	}
		
	public Conta[] criarConta(Conta [] listaConta, int id ) {  
		

		Conta novaConta = new Conta();

		listaConta[id + 1] = novaConta;
		return listaConta;
	}
	
	public boolean fecharConta(int ID, Conta [] lista) { 
		
		for (int i = ID + 1; i < lista.length; i++) {
			lista[i].ID = lista[i].ID - 1;
			lista[i - 1] = lista[i];
		}
		return true;
	}
}
