package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Menu Principal");

        JButton btnFuncionario = new JButton("Funcionário");
        JButton btnCliente = new JButton("Cliente");
        JButton btnSair = new JButton("Sair");

        // Ação para o botão Funcionário
        btnFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuFuncionario().setVisible(true); // Exibe o menu do funcionário.
                dispose(); // Fecha o menu principal.
            }
        });

        // Ação para o botão Cliente
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuCliente().setVisible(true); // Exibe o menu do cliente.
                dispose(); // Fecha o menu principal.
            }
        });

        // Ação para o botão Sair
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Encerra a aplicação.
            }
        });

        JPanel panel = new JPanel();
        panel.add(btnFuncionario);
        panel.add(btnCliente);
        panel.add(btnSair);

        add(panel);
        
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPrincipal(); // Inicia a aplicação mostrando o menu principal.
    }
}
