/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disponibilizado;

/**
 *
 * @author Uallis
 */
public class ClienteImpl implements Cliente {
    private int codigo;
    private String nome;
    private double rendaMensal;

    public ClienteImpl(int codigo, String nome, double rendaMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.rendaMensal = rendaMensal;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public double getRendaMensal() {
        return rendaMensal;
    }

    @Override
    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
}