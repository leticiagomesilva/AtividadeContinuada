package br.edu.cesarschool.cc.poo.ac.cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TelaCliente {
	
	private static final Scanner ENTRADA = new Scanner(System.in);
	private static final BufferedReader ENTRADA_STR = new BufferedReader(new InputStreamReader(System.in));
	private ClienteMediator clienteMediator = ClienteMediator.obterInstancia(); 
	
	public void inicializaTelasCadastroCliente() {
		while(true) {
						
			imprimeMenuPrincipal();
			int opcao = ENTRADA.nextInt();
			
			if (opcao == 1) {				
				processaInclusao();
				
			} else if (opcao == 2) {
				processaAlteracao();
				
			} else if (opcao == 3) {
				processaExclusao();
				
			} else if (opcao == 4) {
				processaBuscar();
				
			} else if (opcao == 5) {
				System.out.println("Saindo do cadastro de clientes");
				System.exit(0);
			} else {
				System.out.println("Opção inválida!!");
			}
		} 
	}
	
	private void imprimeMenuPrincipal() {		
		System.out.println("1- Incluir");
		System.out.println("2- Alterar");
		System.out.println("3- Excluir");
		System.out.println("4- Buscar");
		System.out.println("5- Sair");
		System.out.print("Digite a opção: ");
	}
		
	private void processaInclusao() {
		System.out.print("Digite o cpf: ");
		String cpfLeitura = lerString();
		System.out.print("Digite o nome: ");
		String nomeLeitura = lerString();
		System.out.print("Digite o saldo Pontos: ");
		double saldoPontosLeitura = lerDouble();
		
		Cliente cliente = new Cliente(cpfLeitura, nomeLeitura, saldoPontosLeitura);
		if(clienteMediator.incluir(cliente) == null) {
			System.out.print("Cliente incluído com sucesso");
		}
		else {
			System.out.print(clienteMediator.incluir(cliente));
		}
	}
	
	private void processaAlteracao() {
		System.out.print("Digite o cpf: ");
		String cpfLeitura = lerString();
		Cliente retorno = clienteMediator.buscar(cpfLeitura);
		if(retorno == null) {
			System.out.print("Cliente não encontrado");
		}
		else {
			System.out.print("Cpf: " + retorno.getCpf());
			System.out.print("Nome: " + retorno.getNome());
			System.out.print("Saldo Pontos: " + retorno.getSaldoPontos());
			System.out.print(" ");
			System.out.print("Digite nome: ");
			String nomeAlt = lerString();
			System.out.print("Digite o saldo Pontos: ");
			double saldoPontosAlt = lerDouble();
			Cliente clienteAlt = new Cliente(cpfLeitura, nomeAlt, saldoPontosAlt);
			if(clienteMediator.alterar(clienteAlt) == null) {
				System.out.print("Cliente alterado com sucesso");
			}
			else {
				System.out.print(clienteMediator.alterar(clienteAlt));
			}
		}
	}
	
	private void processaExclusao() {
		System.out.print("Digite o cpf: ");
		String cpfLeitura = lerString();
		Cliente retorno = clienteMediator.buscar(cpfLeitura);
		if(retorno == null) {
			System.out.println("Cliente não encontrado");
		}
		else {
			System.out.print("Cpf: " + retorno.getCpf());
			System.out.print("Nome: " + retorno.getNome());
			System.out.print("Saldo Pontos: " + retorno.getSaldoPontos());
			System.out.print(" ");
			if(clienteMediator.excluir(cpfLeitura) == null) {
				System.out.println("Cliente excluído com sucesso");
			}
			else {
				System.out.println(clienteMediator.excluir(cpfLeitura));
			}
		}
	}
	
	private void processaBuscar() {
		System.out.print("Digite o cpf: ");
		String cpfLeitura = lerString();
		Cliente retorno = clienteMediator.buscar(cpfLeitura);
		if(retorno == null) {
			System.out.print("Cliente não encontrado");
		}
		else {
			System.out.print("Cpf: " + retorno.getCpf());
			System.out.print("Nome: " + retorno.getNome());
			System.out.print("Saldo Pontos: " + retorno.getSaldoPontos());
			System.out.print(" ");
		}
	}
	
	private String lerString() {
		try {			
			return ENTRADA_STR.readLine();			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private double lerDouble() {
		try {			
			return ENTRADA.nextDouble();			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}