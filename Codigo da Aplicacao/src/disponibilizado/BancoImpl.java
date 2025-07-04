/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disponibilizado;

/**
 *
 * @author Uallis
 */
import java.util.ArrayList;
import java.util.Calendar;

public class BancoImpl implements Banco {
    private ArrayList<Conta> contas;

    public BancoImpl() {
        this.contas = new ArrayList<>();
    }

    @Override
    public Conta[] getContas() {
        return contas.toArray(new Conta[0]);
    }

    @Override
    public boolean adicionaConta(Conta conta) {
        return contas.add(conta);
    }

    @Override
    public boolean removeConta(Conta conta) {
        return contas.remove(conta);
    }

    @Override
    public Conta buscaConta(Conta conta) {
        for (Conta c : contas) {
            if (c.getNumero().equals(conta.getNumero())) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Conta[] getContasSaldoNegativo() {
        ArrayList<Conta> contasNegativas = new ArrayList<>();
        for (Conta c : contas) {
            if (c.getSaldo() < 0) {
                contasNegativas.add(c);
            }
        }
        return contasNegativas.toArray(new Conta[0]);
    }

    @Override
    public String[] getNomesClientesRendaMensal(double minimo, double maximo) {
        ArrayList<String> nomes = new ArrayList<>();
        for (Conta c : contas) {
            if (c.getCliente().getRendaMensal() >= minimo && c.getCliente().getRendaMensal() <= maximo) {
                nomes.add(c.getCliente().getNome());
            }
        }
        return nomes.toArray(new String[0]);
    }

    @Override
    public Conta[] getContasPorVolumeCreditoRecebidoPeriodo(double montante, Calendar data) {
        ArrayList<Conta> contasComCredito = new ArrayList<>();
        for (Conta c : contas) {
            double totalCredito = 0;
            for (TransacaoBancaria t : c.getExtrato().getTransacoesBancarias()) {
                if (t.getTipo().equals("D") || t.getTipo().equals("T")) {
                    if (t.getData().after(data)) {
                        totalCredito += t.getValor();
                    }
                }
            }
            if (totalCredito > montante) {
                contasComCredito.add(c);
            }
        }
        return contasComCredito.toArray(new Conta[0]);
    }
}