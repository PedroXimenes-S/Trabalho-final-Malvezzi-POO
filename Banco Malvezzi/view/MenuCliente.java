package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.BancoController;
import model.Conta;

public class MenuCliente extends JFrame {

     private BancoController controller;

     public MenuCliente() {

         controller = new BancoController();

         setTitle("Menu Cliente");

         JButton btnSaldo = new JButton("Consultar Saldo");
         JButton btnDepositar = new JButton("Depositar");
         JButton btnSacar = new JButton("Sacar");
         JButton btnExtrato = new JButton("Gerar Extrato");

         btnSaldo.addActionListener(e -> consultarSaldo());
         btnDepositar.addActionListener(e -> depositar());
         btnSacar.addActionListener(e -> sacar());
         btnExtrato.addActionListener(e -> gerarExtrato());
         

         JPanel panel = new JPanel();
         
         panel.add(btnSaldo);
         panel.add(btnDepositar);
         panel.add(btnSacar);
         panel.add(btnExtrato);

         add(panel);
         
         setSize(400, 200);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }

     private void consultarSaldo() {
         String numeroStr = JOptionPane.showInputDialog(this, "Número da conta:");
         int numero = Integer.parseInt(numeroStr);

         Conta conta = controller.consultarConta(numero);

         if (conta != null) {
             JOptionPane.showMessageDialog(this, "Saldo: R$" + conta.consultarSaldo());
         } else {
             JOptionPane.showMessageDialog(this, "Conta não encontrada!");
         }
     }

     private void depositar() {
         String numeroStr = JOptionPane.showInputDialog(this, "Número da conta:");
         int numero = Integer.parseInt(numeroStr);

         double valor = Double.parseDouble(JOptionPane.showInputDialog(this, "Valor do depósito:"));

         Conta conta = controller.consultarConta(numero);
         
          if (conta != null) { 
              conta.depositar(valor); 
              JOptionPane.showMessageDialog(this, "Depósito realizado com sucesso!"); 
          } else { 
              JOptionPane.showMessageDialog(this, "Conta não encontrada!"); 
          } 
      }

      private void sacar() { 
          String numeroStr = JOptionPane.showInputDialog(this, "Número da conta:"); 
          int numero = Integer.parseInt(numeroStr); 

          double valor = Double.parseDouble(JOptionPane.showInputDialog(this, "Valor do saque:")); 

          Conta conta = controller.consultarConta(numero); 
          
          if (conta != null) { 
              conta.sacar(valor); 
              JOptionPane.showMessageDialog(this, "Saque realizado com sucesso!"); 
          } else { 
              JOptionPane.showMessageDialog(this, "Conta não encontrada!"); 
          } 
      }

      private void gerarExtrato() { 
          String numeroStr = JOptionPane.showInputDialog(this, "Número da conta:"); 
          int numero = Integer.parseInt(numeroStr); 

          Conta conta = controller.consultarConta(numero); 

          if (conta != null) { 
              StringBuilder sb = new StringBuilder(); 
              for (String transacao : conta.getExtrato()) { 
                  sb.append(transacao).append("\n"); 
              } 
              JOptionPane.showMessageDialog(this, sb.toString(), "Extrato", JOptionPane.INFORMATION_MESSAGE); 
          } else { 
              JOptionPane.showMessageDialog(this, "Conta não encontrada!"); 
          } 
      }
}
