package projeto;

import java.util.Scanner;

public class Main {
	
	public static void menu() {
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
		System.out.println("0 - FINALIZAR OPERAÇÕES");
	}
	
	public static int selecaoID (Cliente [] listaClientes, int quantidadeClientes, Scanner sc) {
		
		for (int i = 0; i< quantidadeClientes; i++) {
			
			if (listaClientes != null) {
				System.out.println("ID CLIENTE: " + listaClientes[i].getID() + " | NOME CLIENTE: " + listaClientes[i].getNome());
			}
		}
		
		System.out.println("Digite o ID do cliente: ");	
		int idSelecionado = sc.nextInt();
		
		idSelecionado --;
		
		while (listaClientes[idSelecionado] == null) {
			
			System.out.println("ID INVÁLIDO! Digite um novo valor: ");	
			idSelecionado = sc.nextInt();
			
			idSelecionado --;
			
		}
		return idSelecionado;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Scanner sc_num = new Scanner(System.in);
		
		int quantidadeClientes = 100; 
		Cliente [] listaClientes = new Cliente[quantidadeClientes];
		Conta [] listaContas = new Conta[quantidadeClientes];
	
		int op, idSelecionado;
		int idControle = 0;
		
		do {
			
			menu();
			op = sc_num.nextInt();
			
			switch(op) {
			
				case 0:
					
					System.out.println("OBRIGADO POR UTILIZAR NOSSOS SERVIÇOS! ATENDIMENTO ENCERRADO");
					break;
					
				case 1: 
					
					int novoID = idControle + 1;
					
					System.out.println("Digite o nome: ");
					String nome = sc.nextLine();
					
					Endereco endereco = new Endereco();
					endereco.cadastrarEndereco();
									
					System.out.println("Digite o telefone: ");
					String telefone = sc.nextLine();
					
					System.out.println("Digite o email: ");
					String email = sc.nextLine();
					
					System.out.println("Digite a identidade: ");
					int identidade = sc_num.nextInt();
					
					System.out.println("Digite o rg: ");
					int rg = sc_num.nextInt();
					
					System.out.println("Digite a renda: ");
					double renda = sc_num.nextDouble();
					
					boolean statusConta = false;
				
					listaClientes[idControle] = new Cliente(novoID, nome, endereco, telefone, email, identidade, rg, renda, statusConta); 
					
					idControle ++;	
					
					break;
					
				case 2:
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					if (listaClientes[idSelecionado].criarConta(idSelecionado, listaContas)) {
						System.out.println("Operação realizada com sucesso!");
					
					} else {
						System.out.println("Não foi possível criar a conta!");
						
					}				
					
					break;
						
				case 3:
										
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					if (listaClientes[idSelecionado].fecharConta(idSelecionado, listaContas)) {
						System.out.println("Operação realizada com sucesso!");
					
					} else {
						System.out.println("Não foi possível fechar a conta!");
						
					}	
					
					break;
							
				case 4:
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					listaClientes[idSelecionado].cadastrarEndereco();
					
					System.out.println("Operação realizada com sucesso!");				
					
					break;
						
				case 5:
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					System.out.println("Digite o telefone: ");
					telefone = sc.nextLine();
					
					if (listaClientes[idSelecionado].atualizarTelefone(telefone)) {
						System.out.println("Operação realizada com sucesso!");
					
					} else {
						System.out.println("Não foi possível atualizar o telefone!");
						
					}				
								
					break;
						
				case 6:
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					System.out.println("Digite o email: ");
					email = sc.nextLine();
					
					if (listaClientes[idSelecionado].atualizarEmail(email)) {
						System.out.println("Operação realizada com sucesso!");
					
					} else {
						System.out.println("Não foi possível atualizar o email");
						
					}	
					
					break; 
					
				case 7:
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					System.out.println("Digite a renda: ");
					renda = sc_num.nextDouble();
					
					if (listaClientes[idSelecionado].atualizarRenda(renda)) {
						System.out.println("Operação realizada com sucesso!");
					
					} else {
						System.out.println("Não foi possível atualizar a renda");
						
					}	
					
					break; 
											
				case 8:
					
					System.out.println("8 - Verificar saldo");
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					double valorSaldo = listaContas[idSelecionado].verificarSaldo();
					
					System.out.println("O saldo disponível é de " + valorSaldo + " reais.");
					
					break; 
					
				case 9:
					
					System.out.println("Digite o valor que deseja depositar: ");
					double valorDeposito = sc_num.nextDouble();
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					if (listaContas[idSelecionado] instanceof Corrente || listaContas[idSelecionado] instanceof Poupanca) {
						
					    if (listaContas[idSelecionado].depositar(valorDeposito)) {
					        System.out.println("Operação realizada com sucesso!");
					        
					    } else {
					        System.out.println("Não foi possível realizar o depósito!");
					    }
					    
					} else {
					    System.out.println("Tipo de conta inválido para depósito!");
					}
				
					break;
														
				case 10:
					
					System.out.println("Digite o valor que deseja sacar: ");
					double valorSaque = sc_num.nextDouble();
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					if (listaContas[idSelecionado] instanceof Corrente || listaContas[idSelecionado] instanceof Poupanca) {
						
					    if (listaContas[idSelecionado].sacar(valorSaque)) {
					        System.out.println("Operação realizada com sucesso!");
					        
					    } else {
					        System.out.println("Não foi possível realizar o saque!");
					    }
					    
					} else {
					    System.out.println("Tipo de conta inválido para saque!");
					}
					
					break; 
					
				case 11:
												
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					if (listaContas[idSelecionado] instanceof Investimento || listaContas[idSelecionado] instanceof Poupanca) {
						
					    System.out.println("Informe o dia base: ");
					    int dia = sc_num.nextInt();
					    	
					    System.out.println("Informe o mês base: ");
					    int mes = sc_num.nextInt();
					    	
					    System.out.println("Informe o ano base: ");
					    int ano = sc_num.nextInt();
					        
					    Data dataCalculo = new Data (dia, mes, ano);
					    	
					    double valorJuros = listaContas[idSelecionado].calcularJuros(dataCalculo);
					    
					    System.out.println("O valor total dos juros até a data indicada é de " + valorJuros + " reais");	        
					    
					} else {
					    System.out.println("Tipo de conta inválido para calcular os juros!");
					}
					
					break; 
						
				case 12:
					
					System.out.println("Digite o valor que deseja investir: ");
					double valorInvestimento = sc_num.nextDouble();
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					if (listaContas[idSelecionado] instanceof Investimento) {
						
					    if (listaContas[idSelecionado].investir(valorInvestimento)) {
					        System.out.println("Operação realizada com sucesso!");
					        
					    } else {
					        System.out.println("Não foi possível realizar o investimento!");
					    }
					    
					} else {
					    System.out.println("Tipo de conta inválido para investimento");
					}
				
					break;

				case 13:
					
					System.out.println("Digite o valor que deseja resgatar: ");
					double valorResgate = sc_num.nextDouble();
					
					idSelecionado = selecaoID(listaClientes, quantidadeClientes, sc_num);
					
					if (listaContas[idSelecionado] instanceof Investimento) {
						
					    if (listaContas[idSelecionado].resgatar(valorResgate)) {
					        System.out.println("Operação realizada com sucesso!");
					        
					    } else {
					        System.out.println("Não foi possível realizar o resgate!");
					    }
					    
					} else {
					    System.out.println("Tipo de conta inválido para o resgate");
					}
				
					break;
							
				default:
					
					System.out.println("OPERAÇÃO INVÁLIDA, ESCOLHA NOVAMENTE");
					break;
			} 
			
		} while (op != 0); 		
				
		sc.close();
		sc_num.close();
	}

}
