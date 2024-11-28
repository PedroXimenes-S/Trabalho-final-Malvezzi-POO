package controller;

import model.*;
import utils.DataManager;

import java.util.ArrayList;
import java.util.List;

public class BancoController {

    private List<Conta> contas = new ArrayList<>();

    public void abrirConta(Conta conta) {
        contas.add(conta);
        salvarDados();
    }

    public void encerrarConta(int numeroConta) {
        contas.removeIf(conta -> conta.getNumero() == numeroConta);
        salvarDados();
    }

    public Conta consultarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null; // Não encontrado
    }

    public void salvarDados() {
        DataManager.salvarContas(contas, "contas.dat");
    }

    public void carregarDados() {
        contas = DataManager.carregarContas("contas.dat");
    }
}
