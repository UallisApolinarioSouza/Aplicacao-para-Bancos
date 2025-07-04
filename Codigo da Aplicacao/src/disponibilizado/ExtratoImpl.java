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

public class ExtratoImpl implements Extrato {
    private ArrayList<TransacaoBancaria> transacoes = new ArrayList<>();
    private int proximoId;

    public ExtratoImpl() {
        this.transacoes = new ArrayList<>();
        this.proximoId = 1;
    }

    @Override
    public int getProximoId() {
        return proximoId;
    }

    @Override
    public TransacaoBancaria[] getTransacoesBancarias() {
        return transacoes.toArray(TransacaoBancaria[]::new);
    }

    @Override
    public boolean adicionaTransacao(TransacaoBancaria t) {
        if (t != null) {
            transacoes.add(t);
            proximoId++;
            return true;
        }
        return false;
    }   
    
    @Override
    public String toString(Calendar dataInicial, Calendar dataFinal) {
        StringBuilder extrato = new StringBuilder("Extrato entre " + dataInicial.getTime() + " e " + dataFinal.getTime() + ":\n");

        for (TransacaoBancaria t : transacoes) {
            Calendar dataTransacao = t.getData();
            if ((dataTransacao.equals(dataInicial) || dataTransacao.after(dataInicial)) &&
                (dataTransacao.equals(dataFinal) || dataTransacao.before(dataFinal))) {
                extrato.append(t.toString()).append("\n");
            }
        }

        return extrato.toString();
    }

    @Override
    public String toString() {
    StringBuilder extrato = new StringBuilder("Extrato:\n");

    for (TransacaoBancaria t : transacoes) {
        extrato.append(t.toString()).append("\n");
    }

    return extrato.toString();
    }   
}