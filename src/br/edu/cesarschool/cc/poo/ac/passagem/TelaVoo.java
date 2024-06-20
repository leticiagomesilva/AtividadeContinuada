package br.edu.cesarschool.cc.poo.ac.passagem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import br.edu.cesarschool.cc.poo.ac.utils.DiaDaSemana;

public class TelaVoo {
	
	private static final Scanner ENTRADA = new Scanner(System.in);
	private static final BufferedReader ENTRADA_STR = new BufferedReader(new InputStreamReader(System.in));
	private VooMediator vooMediator = VooMediator.obterInstancia(); 
	
	public void inicializaTelasCadastroVoos() {
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
				System.out.println("Saindo do cadastro de voos");
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
		System.out.print("Digite o aeroporto origem: ");
		String aeroportoOrigem = lerString();
		System.out.print("Digite o aeroporto destino: ");
		String aeroportoDestino = lerString();
		System.out.print("Digite a companhia area: ");
		String companhiaAerea = lerString();
		System.out.print("Digite o número do voo: ");
		int numeroVoo = lerInt();
		
		DiaDaSemana diaDaSemana = lerDiaDaSemana();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		System.out.print("Digite a hora: ");
		String hora = lerString();
		LocalTime horario;
		
		try {
			horario = LocalTime.parse(hora, formatter);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		Voo voo = new Voo(aeroportoOrigem, aeroportoDestino, companhiaAerea, numeroVoo, new DiaDaSemana[]{diaDaSemana}, horario);
		if(vooMediator.incluir(voo) == null) {
			System.out.print("Voo incluído com sucesso");
		}
		else {
			System.out.print(vooMediator.incluir(voo));
		}
	}
	
	private void processaAlteracao() {
		System.out.print("Digite o ID do voo: ");
		String idLeitura = lerString();
		Voo retorno = vooMediator.buscar(idLeitura);
		if(retorno == null) {
			System.out.print("Voo não encontrado");
		}
		else {
			System.out.print("Destino: " + retorno.getAeroportoDestino());
			System.out.print("Origem: " + retorno.getAeroportoOrigem());
			System.out.print("Companhia aerea: " + retorno.getCompanhiaAerea());
			System.out.print("Número do voo: " + retorno.getNumeroVoo());
			System.out.print("Dia da semana: " + retorno.getDiasDaSemana());
			System.out.print("Hora: " + retorno.getHora());
			System.out.print(" ");
			System.out.print("Digite o novo dia: ");
			
			DiaDaSemana novoDiaDaSemana = lerDiaDaSemana();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
			System.out.print("Digite a nova hora: ");
			String novaHora = lerString();
			LocalTime novoHorario;
			
			try {
				novoHorario = LocalTime.parse(novaHora, formatter);
			}catch (Exception e) {
				throw new RuntimeException(e);
			}

			Voo vooAlt = new Voo(retorno.getAeroportoOrigem(), retorno.getAeroportoDestino(), retorno.getCompanhiaAerea(),retorno.getNumeroVoo(), new DiaDaSemana[]{novoDiaDaSemana}, novoHorario) ;
			if(vooMediator.alterar(vooAlt) == null) {
				System.out.print("Voo alterado com sucesso");
			}
			else {
				System.out.print(vooMediator.alterar(vooAlt));
			}
		}
	}
	
	private void processaExclusao() {
		System.out.print("Digite o ID do voo: ");
		String idLeitura = lerString();
		Voo retorno = vooMediator.buscar(idLeitura);
		if(retorno == null) {
			System.out.println("Voo não encontrado");
		}
		else {
			System.out.print("Destino: " + retorno.getAeroportoDestino());
			System.out.print("Origem: " + retorno.getAeroportoOrigem());
			System.out.print("Companhia aerea: " + retorno.getCompanhiaAerea());
			System.out.print("Número do voo: " + retorno.getNumeroVoo());
			System.out.print("Dia da semana: " + retorno.getDiasDaSemana());
			System.out.print("Hora: " + retorno.getHora());
			System.out.print(" ");
			if(vooMediator.excluir(idLeitura) == null) {
				System.out.println("Voo excluído com sucesso");
			}
			else {
				System.out.println(vooMediator.excluir(idLeitura));
			}
		}
	}
	
	private void processaBuscar() {
		System.out.print("Digite o ID do voo: ");
		String idLeitura = lerString();
		Voo retorno = vooMediator.buscar(idLeitura);
		if(retorno == null) {
			System.out.print("Voo não encontrado");
		}
		else {
			System.out.print("Destino: " + retorno.getAeroportoDestino());
			System.out.print("Origem: " + retorno.getAeroportoOrigem());
			System.out.print("Companhia aerea: " + retorno.getCompanhiaAerea());
			System.out.print("Número do voo: " + retorno.getNumeroVoo());
			System.out.print("Dia da semana: " + retorno.getDiasDaSemana());
			System.out.print("Hora: " + retorno.getHora());
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
	
	private int lerInt() {
		try {			
			return ENTRADA.nextInt();			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	 private DiaDaSemana lerDiaDaSemana() {
        System.out.println("Escolha o dia da semana:");
        System.out.println("1. Segunda-feira");
        System.out.println("2. Terça-feira");
        System.out.println("3. Quarta-feira");
        System.out.println("4. Quinta-feira");
        System.out.println("5. Sexta-feira");
        System.out.println("6. Sábado");
        System.out.println("7. Domingo");

        int opcao = lerInt();
        while (opcao < 1 || opcao > 7) {
            System.out.println("Opção inválida. Escolha um número de 1 a 7:");
            opcao = lerInt();
        }

        return DiaDaSemana.getDiaDaSemana(opcao);
	 }

}