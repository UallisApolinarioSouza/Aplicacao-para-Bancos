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

public class ContaCorrente extends ContaBase {
    
    public ContaCorrente() {}

    public ContaCorrente(String numero, Cliente cliente, Calendar dataAbertura, String senha) {
        super(numero, cliente, dataAbertura, senha);
    }
}