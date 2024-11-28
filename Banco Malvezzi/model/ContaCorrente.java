package model;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numero, double limite) {
        super(numero);
        this.limite = limite;
        this.tipoConta = "Corrente";
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        extrato.add("Depósito: R$" + valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            extrato.add("Saque: R$" + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double getLimite() {
        return limite;
    }
}
