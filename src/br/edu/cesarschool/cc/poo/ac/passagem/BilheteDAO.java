package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.cc.poo.ac.utils.Registro;
import br.edu.cesarschool.cc.poo.ac.utils.SuperDAO;

public class BilheteDAO extends SuperDAO {
    @Override
    public Class<?> obterTipo() {
        return Bilhete.class;
    }

    private String obterIdUnico(Bilhete bilhete) {
        return bilhete.gerarNumero();
    }

    public Bilhete buscar(String numeroBilhete) {
        return (Bilhete) daoGenerico.buscar(numeroBilhete);
    }

    public boolean incluir(Bilhete bilhete) {
        String idUnico = obterIdUnico(bilhete);
        Bilhete bilheteIncluir = buscar(idUnico);
        if (bilheteIncluir == null) {
            daoGenerico.incluir(bilhete);
            return true;
        }
        return false;
    }

    public boolean alterar(Bilhete bilhete) {
        String idUnico = obterIdUnico(bilhete);
        Bilhete bilheteAlterar = buscar(idUnico);
        if (bilheteAlterar != null) {
            daoGenerico.alterar(bilhete);
            return true;
        }
        return false;
    }

    public boolean excluir(String numeroBilhete) {
        Bilhete bilheteExcluir = buscar(numeroBilhete);
        if (bilheteExcluir != null) {
            daoGenerico.excluir(numeroBilhete);
            return true;
        }
        return false;
    }
    
    public Bilhete[] buscarTodos() {
		Registro[] registros = daoGenerico.buscarTodos();
		Bilhete[] bilhetes = new Bilhete[registros.length];
		for (int i = 0; i < registros.length; i++) {
			bilhetes[i] = (Bilhete) registros[i];
		}
		return bilhetes;
	}
}