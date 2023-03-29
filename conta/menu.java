package conta;

import java.util.Scanner;
//import conta.model.Conta;
import conta.util.Cores;
import conta.model.*;


public class menu {

	public static void main(String[] args) {
		
		//Teste da Classe Conta
		
		/*Conta c1 = new Conta (1, 123, 1, "Adriana", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar(); */
		
		//Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 123 ,1, "Mariana",  15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		//Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		
		
			Scanner input = new Scanner(System.in);
			int opcao;
			while (true) {
				
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD_BRIGHT);
				System.out.println("************************************************************************");
				System.out.println("*                       Banco Generation                               *");
				System.out.println("************************************************************************");
				System.out.println("| (1)  Criar conta             |  (2) Listar todas as contas           |");
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
				opcao = input.nextInt();

				if (opcao == 9) {
					System.out.println("Banco Generation sempre à sua disposição!");
					input.close();
					System.exit(0);

				}
				switch (opcao) {
				case 1:
					System.out.println("Criar conta\n\n");

					break;
				case 2:
					System.out.println("Listar todas as contas\n\n");

					break;
				case 3:
					System.out.println("Buscar conta por número\n\n");

					break;
				case 4:
					System.out.println("Atualizar dados da conta\n\n");

					break;
				case 5:
					System.out.println("Apagar conta\n\n");

					break;
				case 6:
					System.out.println("Sacar\n\n");

					break;
				case 7:
					System.out.println("Depositar\n\n");

					break;
				case 8:
					System.out.println("Transferir valores entre contas\n\n");

					break;
				default:
					System.out.println("Opção inválida. Por favor, insira uma opção válida.\n");
				}

	}
}
}
