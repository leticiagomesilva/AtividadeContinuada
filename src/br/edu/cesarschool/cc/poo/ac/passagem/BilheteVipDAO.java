package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.cc.poo.ac.utils.SuperDAO;

public class BilheteVipDAO extends SuperDAO {
    @Override
    public Class<?> obterTipo() {
        return BilheteVip.class;
    }

    private String obterIdUnico(BilheteVip bilheteVip) {
        return bilheteVip.gerarNumero();
    }

    public BilheteVip buscar(String numeroBilhete) {
        return (BilheteVip) daoGenerico.buscar(numeroBilhete);
    }

    public boolean incluir(BilheteVip bilheteVip) {
        String idUnico = obterIdUnico(bilheteVip);
        BilheteVip bilheteVipIncluir = buscar(idUnico);
        if (bilheteVipIncluir == null) {
            daoGenerico.incluir(bilheteVip);
            return true;
        }
        return false;
    }

    public boolean alterar(BilheteVip bilheteVip) {
        String idUnico = obterIdUnico(bilheteVip);
        BilheteVip bilheteVipAlterar = buscar(idUnico);
        if (bilheteVipAlterar != null) {
            daoGenerico.alterar(bilheteVip);
            return true;
        }
        return false;
    }

    public boolean excluir(String numeroBilhete) {
        BilheteVip bilheteExcluir = buscar(numeroBilhete);
        if (bilheteExcluir != null) {
            daoGenerico.excluir(numeroBilhete);
            return true;
        }
        return false;
    }
}