package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.cc.poo.ac.utils.SuperDAO;

public class VooDAO extends SuperDAO {
    @Override
    public Class<?> obterTipo() {
        return Voo.class;
    }

    private String obterIdUnico(Voo voo) {
        return voo.getCompanhiaAerea() + voo.getNumeroVoo();
    }

    public Voo buscar(String idVoo) {
        return (Voo) daoGenerico.buscar(idVoo);
    }

    public boolean incluir(Voo voo) {
        String idUnico = obterIdUnico(voo);
        Voo vooIncluir = buscar(idUnico);
        if (vooIncluir == null) {
            daoGenerico.incluir(voo);
            return true;
        }
        return false;
    }

    public boolean alterar(Voo voo) {
        String idUnico = obterIdUnico(voo);
        Voo vooAlterar = buscar(idUnico);
        if (vooAlterar != null) {
            daoGenerico.alterar(voo);
            return true;
        }
        return false;
    }

    public boolean excluir(String idVoo) {
        Voo vooExcluir = buscar(idVoo);
        if (vooExcluir != null) {
            daoGenerico.excluir(idVoo);
            return true;
        }
        return false;
    }
}