package br.edu.cesarschool.cc.poo.ac.utils;

public class ValidadorCPF {
	
	public ValidadorCPF() {}
	
	public static boolean isCpfValido(String cpf) {
		if(cpf==null || cpf=="" || cpf.length()!=11) {
			return false;
		}
		for (int i = 0; i < cpf.length(); i++) {
	        if (!Character.isDigit(cpf.charAt(i))) {
	        	return false;
	        }
	    }
	    int soma = 0;
	    for (int i = 0; i < 9; i++) {
	    	soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
	    }
	    int resto = soma % 11;
	    int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);
	    if (digitoVerificador1 != Character.getNumericValue(cpf.charAt(9))) {
	    	return false;
	    }
	    soma = 0;
	    for (int i = 0; i < 10; i++) {
	    	soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
	    }
	    resto = soma % 11;
	    int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);
	    if (digitoVerificador2 != Character.getNumericValue(cpf.charAt(10))) {
	    	return false;
	    }
	    return true;
	}
	public static boolean validar(String getcpf) {
		
		return false;
	}
}