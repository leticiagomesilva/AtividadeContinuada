package br.edu.cesarschool.cc.poo.ac.passagem;

import java.time.LocalTime;
import java.util.Arrays;

import br.edu.cesarschool.cc.poo.ac.utils.StringUtils;

public class VooMediator {
	
	private static VooMediator instancia;
	
	private VooDAO vooDao = new VooDAO();
	
	private VooMediator() {
		
	}
	
	public static VooMediator obterInstancia() {
		if(instancia == null) {
			instancia = new VooMediator();
		}
		return instancia;
	}
	
	private static final String[] AeroportosValidos = {"GRU", "CGH", "GIG", "SDU", "REC", "CWB", "POA", "BSB", "SSA", "FOR", "MAO", "SLZ", "CNF", "BEL", "JPA", "PNZ", "CAU", "FEN", "SET", "NAT", "PVH", "BVB", "FLN", "AJU", "PMW", "MCZ", "MCP", "VIX", "GYN", "CGB", "CGR", "THE", "RBR", "VCP", "RAO"};
	
	public Voo buscar(String IdVoo) {
		return vooDao.buscar(IdVoo);
	}
	
	public String validarCiaNumero(String companhiaAerea, int numeroVoo) {
	    if (StringUtils.isVaziaOuNula(companhiaAerea) || companhiaAerea.length() != 2) {
	        return "CIA aerea errada";
	    }
	    if (numeroVoo < 1001 || numeroVoo > 9999) {
	        return "Numero voo errado";
	    }
	    else {
	    	return null; 
	    }
	}
	
	public String validar(Voo voo) {
	    String[] AeroportosValidos = {"GRU", "CGH", "GIG", "SDU", "REC", "CWB", "POA", "BSB", "SSA", "FOR", "MAO", "SLZ", "CNF", "BEL", "JPA", "PNZ", "CAU", "FEN", "SET", "NAT", "PVH", "BVB", "FLN", "AJU", "PMW", "MCZ", "MCP", "VIX", "GYN", "CGB", "CGR", "THE", "RBR", "VCP", "RAO"};
	    
	    if (StringUtils.isVaziaOuNula(voo.getAeroportoOrigem()) || !Arrays.asList(AeroportosValidos).contains(voo.getAeroportoOrigem())) {
	        return "Aeroporto origem errado";
	    }
	    
	    if (StringUtils.isVaziaOuNula(voo.getAeroportoDestino()) || !Arrays.asList(AeroportosValidos).contains(voo.getAeroportoDestino())) {
	        return "Aeroporto destino errado";
	    }
	    
	    if (voo.getAeroportoOrigem().equals(voo.getAeroportoDestino())) {
	        return "Aeroporto origem igual a aeroporto destino";
	    }
	    
	    String validacaoCiaNumero = validarCiaNumero(voo.getCompanhiaAerea(), voo.getNumeroVoo());
	    if (validacaoCiaNumero != null) {
	        return validacaoCiaNumero;
	    }
	    
	    if (voo.getDiasDaSemana() == null || voo.getDiasDaSemana().length == 0) {
            return "Dias da semana nao informados";
        }
	    
	    if (Arrays.stream(voo.getDiasDaSemana()).distinct().count() != voo.getDiasDaSemana().length) {
	        return "Dia da semana repetido";
	    }
	    
	    if (voo.getHora() == null) {
	        return "Hora nao informada";
	    }

	    LocalTime hora = voo.getHora();
	    if (hora.getSecond() != 0 || hora.getNano() != 0) {
	        return "Hora invalida";
	    }
	    return null; 
	}

	
	public String incluir(Voo voo) {
		if(validar(voo) != null) {
			return validar(voo);
		}
		else {
			if(!vooDao.incluir(voo)) {
				return "Voo ja existente";
			}
			else {
				return null;
			}
		}
	}
	
	public String alterar(Voo voo) {
		if(validar(voo) != null) {
			return validar(voo);
		}
		else {
			if(!vooDao.alterar(voo)) {
				return "Voo inexistente";
			}
			else {
				return null;
			}
		}
	}
	
	public String excluir(String idVoo) {
		if(StringUtils.isVaziaOuNula(idVoo)){
			return "Id voo errado";
		}
		else {
			if(!vooDao.excluir(idVoo)) {
				return "Voo inexistente";
			}
			else {
				return null;
			}
		}
	}
	
	
}
