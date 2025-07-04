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

public interface Banco {
    Conta[] getContas();
    boolean adicionaConta(Conta conta);
    boolean removeConta(Conta conta);
    Conta buscaConta(Conta conta);
    Conta[] getContasSaldoNegativo();
    String[] getNomesClientesRendaMensal(double minimo, double maximo);
    Conta[] getContasPorVolumeCreditoRecebidoPeriodo(double montante, Calendar data);
}