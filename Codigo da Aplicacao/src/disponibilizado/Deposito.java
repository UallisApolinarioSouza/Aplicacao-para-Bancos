/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disponibilizado;

/**
 *
 * @author Uallis
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Deposito implements TransacaoBancaria {
    private final int id;
    private final double valor;
    private final String tipo = "D";
    private final Calendar data;

    public Deposito(int id, double valor, Calendar data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public Calendar getData() {
        return data;
    } 

    @Override
    public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    return "Deposito{" + "id=" + id + ", valor=" + valor + ", tipo=" + tipo + ", data=" + sdf.format(data.getTime()) + '}';
    }
}