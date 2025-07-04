/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package disponibilizado;

/**
 *
 * @author Uallis
 */
public interface Cliente {

    int getCodigo();

    String getNome();
    
    double getRendaMensal();

    void setCodigo(int codigo);

    void setNome(String nome);
    
    void setRendaMensal(double rendaMensal);
    
}