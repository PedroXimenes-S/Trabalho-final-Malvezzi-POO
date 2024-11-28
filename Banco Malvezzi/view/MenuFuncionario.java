package view;

import javax.swing.*;
import controller.BancoController;
import model.ContaCorrente;
import model.ContaPoupanca;

	public class MenuFuncionario extends JFrame {

     private BancoController controller;

     public MenuFuncionario() {

         controller = new BancoController();

         setTitle("Menu Funcionário");

         JButton btnAberturaConta = new JButton("Abertura de Conta");
         JButton btnEncerrarConta = new JButton("Encerrar Conta");

         btnAberturaConta.addActionListener(e -> abrirConta());
         btnEncerrarConta.addActionListener(e -> encerrarConta());

         JPanel panel = new JPanel();
         panel.add(btnAberturaConta);
         panel.add(btnEncerrarConta);

         add(panel);
         setSize(300, 200);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }

     private void abrirConta() {
         String numeroStr = JOptionPane.showInputDialog(this, "Número da conta:");
         int numero = Integer.parseInt(numeroStr);

         String tipoStr = JOptionPane.showInputDialog(this, "Tipo de conta (Corrente/Poupança):");

         if ("Corrente".equalsIgnoreCase(tipoStr)) {
             String limiteStr = JOptionPane.showInputDialog(this, "Limite:");
             double limite = Double.parseDouble(limiteStr);
             controller.abrirConta(new ContaCorrente(numero, limite));
             JOptionPane.showMessageDialog(this, "Conta Corrente criada com sucesso!");
         } else if ("Poupança".equalsIgnoreCase(tipoStr)) {
             controller.abrirConta(new ContaPoupanca(numero));
             JOptionPane.showMessageDialog(this, "Conta Poupança criada com sucesso!");
         } else {
             JOptionPane.showMessageDialog(this, "Tipo de conta inválido!");
         }
     }

     private void encerrarConta() {
         String numeroStr = JOptionPane.showInputDialog(this, "Número da conta a ser encerrada:");
         int numero = Integer.parseInt(numeroStr);

         controller.encerrarConta(numero);
         JOptionPane.showMessageDialog(this, "Conta encerrada com sucesso!");
     }
}
