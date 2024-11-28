package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements Serializable {
    protected int numero;
    protected double saldo;
    protected String tipoConta;
    protected List<String> extrato;

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0.0;
        this.extrato = new ArrayList<>();
    }

    public abstract void depositar(double valor);
    public abstract void sacar(double valor);
    
    public double consultarSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public List<String> getExtrato() {
        return extrato;
    }
}
