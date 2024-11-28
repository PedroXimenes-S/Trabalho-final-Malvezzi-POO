package model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero) {
        super(numero);
        this.tipoConta = "Poupança";
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        extrato.add("Depósito: R$" + valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            extrato.add("Saque: R$" + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
