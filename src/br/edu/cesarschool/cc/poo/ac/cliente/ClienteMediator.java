package br.edu.cesarschool.cc.poo.ac.cliente;

import br.edu.cesarschool.cc.poo.ac.utils.ValidadorCPF;
import br.edu.cesarschool.cc.poo.ac.utils.ordenacao.Comparador;
import br.edu.cesarschool.cc.poo.ac.utils.ordenacao.Ordenadora;
import br.edu.cesarschool.cc.poo.ac.utils.StringUtils;

public class ClienteMediator {
	
	private static ClienteMediator instancia;
	
	private ClienteDAO clienteDao = new ClienteDAO();
	
	private ClienteMediator() {
		
	}
	
	public static ClienteMediator obterInstancia() {
		if(instancia == null) {
			instancia = new ClienteMediator();
		}
		return instancia;
	}
	
	public Cliente buscar(String cpf) {
		return clienteDao.buscar(cpf);
	}
	
	public String validar(Cliente cliente) {
		if(ValidadorCPF.isCpfValido(cliente.getCpf()) == false){
			return "CPF errado";
		}
		if(StringUtils.isVaziaOuNula(cliente.getNome()) || cliente.getNome().length() < 2) {
			return "nome errado";
		}
		if(cliente.getSaldoPontos() < 0) {
			return "saldo errado";
		}
		else {
			return null;
		}
	}
	
	public String incluir(Cliente cliente) {
		if(validar(cliente) != null) {
			return validar(cliente);
		}
		else {
			if(clienteDao.incluir(cliente) == false) {
				return "Cliente ja existente";
			}
			else {
				return null;
			}
		}
	}
	
	public String alterar(Cliente cliente) {
		if(validar(cliente) != null) {
			return validar(cliente);
		}
		else {
			if(clienteDao.alterar(cliente) == false) {
				return "Cliente inexistente";
			}
			else {
				return null;
			}
		}
	}
	
	public String excluir(String cpf) {
		if(ValidadorCPF.isCpfValido(cpf) == false){
			return "CPF errado";
		}
		else {
			if(clienteDao.excluir(cpf) == false) {
				return "Cliente inexistente";
			}
			else {
				return null;
			}
		}
		
	}
	
	public Cliente[] obterClientesPorNome() {
		Cliente[] todosClientes = clienteDao.buscarTodos();
		Comparador comparadorNome = new Comparador() {
			@Override
			public int comparar(Object o1, Object o2) {
				Cliente cliente1 = (Cliente) o1;
				Cliente cliente2 = (Cliente) o2;
				return cliente1.getNome().compareToIgnoreCase(cliente2.getNome());
			}
		};
		Ordenadora.ordenar(todosClientes, comparadorNome);
		return todosClientes;
	}
	
}
