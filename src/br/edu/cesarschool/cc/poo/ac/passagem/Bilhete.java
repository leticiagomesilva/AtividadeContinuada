package br.edu.cesarschool.cc.poo.ac.passagem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.edu.cesarschool.cc.poo.ac.cliente.Cliente;
import br.edu.cesarschool.cc.poo.ac.utils.Registro;

public class Bilhete extends Registro {
    private Cliente cliente;
    private Voo voo;
    private double preco;
    private double pagamentoEmPontos;
    private LocalDateTime dataHora;

    public Bilhete(Cliente cliente, Voo voo, double preco, double pagamentoEmPontos, LocalDateTime dataHora) {
        super();
        this.cliente = cliente;
        this.voo = voo;
        this.preco = preco;
        this.pagamentoEmPontos = pagamentoEmPontos;
        this.dataHora = dataHora;
    }

    public void setPagamentoEmPontos(double novoPagamentoEmPontos) {
        this.pagamentoEmPontos = novoPagamentoEmPontos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Voo getVoo() {
        return voo;
    }

    public double getPreco() {
        return preco;
    }

    public double getPagamentoEmPontos() {
        return pagamentoEmPontos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double obterValorPago() {
        return getPreco() - getPagamentoEmPontos();
    }

    public double obterValorPontuacao() {
        return obterValorPago() / 20;
    }

    public String gerarNumero() {
        return cliente.getCpf() + voo.getNumeroVoo() + dataHora.getYear() + dataHora.getMonthValue() + dataHora.getDayOfMonth();
    }

    @Override
    public String getIdUnico() {
        return gerarNumero();
    }

    @Override
	public String toString() {
		return preco + voo.getAeroportoOrigem() + voo.getAeroportoDestino() + dataHora;
	}
}