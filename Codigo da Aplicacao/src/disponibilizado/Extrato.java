/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package disponibilizado;

/**
 *
 * @author Uallis
 */
import java.util.Calendar;

public interface Extrato {
    int getProximoId();
    TransacaoBancaria[] getTransacoesBancarias();
    boolean adicionaTransacao(TransacaoBancaria t);
    String toString(Calendar dataInicial, Calendar dataFinal);
}