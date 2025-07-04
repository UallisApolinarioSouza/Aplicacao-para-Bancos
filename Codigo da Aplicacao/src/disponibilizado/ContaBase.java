/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disponibilizado;

/**
 *
 * @author Uallis
 */
import java.util.Calendar;

public abstract class ContaBase implements Conta {
    protected String numero;
    protected Cliente cliente;
    protected Calendar dataAbertura;
    protected Extrato extrato;
    protected double saldo;
    protected String senha;

    public ContaBase() {}

    public ContaBase(String numero, Cliente cliente, Calendar dataAbertura, String senha) {
        this.numero = numero;
        this.cliente = cliente;
        this.dataAbertura = dataAbertura;
        this.senha = senha;
        this.extrato = new ExtratoImpl();
        this.saldo = 0.0;
    }

    @Override
    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    @Override
    public Extrato getExtrato() {
        return extrato;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    @Override
    public void setExtrato(Extrato extrato) {
        this.extrato = extrato;
    }

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public void setSenha(String senhaAtual, String novaSenha) {
        if (this.senha.equals(senhaAtual)) {
            this.senha = novaSenha;
        } else {
            throw new SecurityException("Senha atual incorreta.");
        }
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            TransacaoBancaria deposito = new Deposito(extrato.getProximoId(), valor, Calendar.getInstance());
            extrato.adicionaTransacao(deposito);
            return true;
        }
        return false;
    }

    @Override
    public boolean sacar(double valor, String senha) {
        if (this.senha.equals(senha) && saldo >= valor && valor > 0) {
            saldo -= valor;
            TransacaoBancaria saque = new Saque(extrato.getProximoId(), valor, Calendar.getInstance());
            extrato.adicionaTransacao(saque);
            return true;
        }
        return false;
    }

    @Override
    public boolean transferirPara(double valor, Conta contaDestino, String senha) {
        if (this.senha.equals(senha) && saldo >= valor && valor > 0) {
            saldo -= valor;
            contaDestino.depositar(valor);
            TransacaoBancaria transferencia = new Transferencia(extrato.getProximoId(), valor, Calendar.getInstance());
            extrato.adicionaTransacao(transferencia);
            return true;
        }
        return false;
    }

    @Override
    public boolean receberTransferencia(double valor, Conta contaOrigem) {
        if (valor > 0) {
            saldo += valor;
            TransacaoBancaria transferencia = new Transferencia(extrato.getProximoId(), valor, Calendar.getInstance());
            extrato.adicionaTransacao(transferencia);
            return true;
        }
        return false;
    }

    @Override
    public String getExtratoToString(Calendar dataInicial, Calendar dataFinal) {
        return extrato.toString(dataInicial, dataFinal);
    }

    @Override
    public String getExtratoToString(Calendar dataInicial) {
        return extrato.toString(dataInicial, Calendar.getInstance());
    }

    @Override
    public String getExtratoToString() {
        return extrato.toString();
    }
}