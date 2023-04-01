package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
//import conta.model.Conta;
import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.*;


public class menu {

	public static void main(String[] args) {
		
		
		ContaController contas = new ContaController();
		
		//Teste da Classe Conta
		
		/*Conta c1 = new Conta (1, 123, 1, "Adriana", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar(); */
		
		/*Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 123 ,1, "Mariana",  15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();*/
		
		/*Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();*/
		
		
		
			Scanner input = new Scanner(System.in);
			Scanner leia = new Scanner (System.in);
			
			int opcao, numero, agencia, tipo, aniversario, numeroDestino;
			String titular;
			float saldo, limite, valor;
			
			while (true) {
				
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD_BRIGHT);
				System.out.println("************************************************************************");
				System.out.println("*                       Banco Generation                               *");
				System.out.println("************************************************************************");
				System.out.println("| (1)  Criar conta             | (2) Listar todas as contas            |");
				System.out.println("|                                                                      |");
				System.out.println("| (3) Buscar conta por número  | (4) Atualizar dados da conta          |");
				System.out.println("|                                                                      |");
				System.out.println("| (5) Apagar conta             | (6) Sacar                             |");
				System.out.println("|                                                                      |");
				System.out.println("| (7) Depositar                | (8) Transferir valores entre contas   |");
				System.out.println("|                                                                      |");
				System.out.println("|************************** (9) Sair **********************************|");
				System.out.println("|                                                                      |");
				System.out.println("|********************* Digite a opção desejada  ***********************|");
				System.out.println("|                                                                      |");
				System.out.println("|______________________________________________________________________|");
				System.out.println(Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_CYAN_BOLD);
				
				try {
					opcao = input.nextInt();					
				} catch (InputMismatchException e) {
					System.out.println("\n Digite valores inteiros! ");
					Scanner leia1 = null;
					leia1.nextLine();
					opcao = 0;
				}

				if (opcao == 9) {
					System.out.println("Banco Generation sempre à sua disposição!");
					input.close();
					System.exit(0);

				}
				switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Criar conta\n\n");
					
					System.out.println("Digite o Número da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					do {
						System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
						tipo = leia.nextInt();
					} while (tipo < 1 && tipo > 2 );
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversário da Conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						
						
					}
					}
					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todas as contas\n\n");
					contas.listarTodas();
					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
					
					System.out.println(" Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.procurarPorNumero(numero);

					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados da conta\n\n");
					
					System.out.println("Digite o número da Conta: ");
					numero = leia.nextInt();
					
					if (contas.buscarNaCollection(numero) != null) {
						System.out.println("Digite o Número da Agência: ");
						agencia = leia.nextInt();
						System.out.println("\n Digite o Nome do Titular: ");
						leia.skip("\\R?");
						titular = leia.nextLine();
						
						System.out.println("Digite o Saldo da Conta (R$): ");
						saldo = leia.nextFloat();
						
						tipo = contas.retornaTipo(numero);
						
						switch (tipo) {
						case 1 -> {
							System.out.println("Digite o Limite de Crédito (R$): ");
							limite = leia.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do Aniversário da Conta: ");
							aniversario = leia.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default -> {
							System.out.println("Tipo de Conta inválido!");
						}
						}
					} else {
						System.out.println("\n Conta não encontrada!");
					}

					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar conta\n\n");
					
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.deletar(numero);

					keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE + "Sacar\n\n");
					
					System.out.println("Digite o Numero da COnta: ");
					numero = leia.nextInt();
					
					do {
						System.out.println("Digite o Valor do Saque (R$): ");
						valor = leia.nextFloat();
					}while (valor<=0);
					
					contas.sacar(numero, valor);

					keyPress();
					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE + "Depositar\n\n");
					
					System.out.println("Digite o número da conta:");
					numero = leia.nextInt();
					
					do {
						System.out.println("Digite o valor do depósito (R$): ");
						valor = leia.nextFloat();
						
					}while (valor <= 0);

					keyPress();
					break;
				case 8:
					System.out.println(Cores.TEXT_WHITE + "Transferir valores entre contas\n\n");
					
					System.out.println("Digite o número da COnta de Origem: ");
					numero = leia.nextInt();
					System.out.println("Digite o Número da Conta de Destino: ");
					numeroDestino = leia.nextInt();
					
					do {
						System.out.println("Digite o valor da Transferência (R$): ");
						valor = leia.nextFloat();
						
					}while (valor <= 0);
					
					contas.transferir(numero, numeroDestino, valor);

					keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida. Por favor, insira uma opção válida.\n" + Cores.TEXT_RESET);
					keyPress();
				}

	}
}   private static void keyPress() {
		// TODO Auto-generated method stub
		
	}
  public static void KeyPress() {
	try {
		System.out.println(Cores.TEXT_RESET + "\n\n Pressione Enter para Continuar...");
		System.in.read();
	} catch (IOException e) {
		System.out.println("Você pressionou uma tecla diferente de enter!");
	}
}
}
	
