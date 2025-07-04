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

public interface Conta {

    Calendar getDataAbertura();

    Extrato getExtrato();

    String getNumero();

    double getSaldo();

    Cliente getCliente();

    void setCliente(Cliente cliente);

    void setDataAbertura(Calendar dataAbertura);

    void setExtrato(Extrato extrato);

    void setNumero(String numero);

    void setSenha(String senhaAtual, String novaSenha);

    boolean depositar(double valor);

    boolean sacar(double valor, String senha);

    boolean transferirPara(double valor, Conta contaDestino, String senha);
    
    boolean receberTransferencia(double valor, Conta contaOrigem);

    /*
     * O metodo getExtratoToString visa facilitar a impressao do extrato
     * para os usuarios da classe. Por exemplo, pode se basear nas
     * informacoes basicas que aparecem em extratos bancarios, como
     * numero da conta,  nome do cliente, data do extrato e informacoes
     * de cada uma das transacoes. O metodo eh sobrecarregado.
     */
    
    //todas as transacoes do periodo
    String getExtratoToString(Calendar dataInicial, Calendar dataFinal);
    //todas as transacoes a partir de uma data
    String getExtratoToString(Calendar dataInicial);
    //todas as transacoes
    String getExtratoToString();
}