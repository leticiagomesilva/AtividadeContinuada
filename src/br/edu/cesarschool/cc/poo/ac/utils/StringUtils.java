package br.edu.cesarschool.cc.poo.ac.utils;

public class StringUtils {

	private StringUtils() {
		super();
	}
	
	public static boolean isVaziaOuNula(String valor) {
		if ( valor == "" || valor == null) { 
			return true;
		}else {
			return false;
		}
	}
}
