package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");

        JTextField usuarioField = new JTextField(20);
        JPasswordField senhaField = new JPasswordField(20);
        JButton btnLogin = new JButton("Login");

        JPanel panel = new JPanel();

        panel.add(new JLabel("Usuário:"));
        panel.add(usuarioField);

        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);

        panel.add(btnLogin);

        frame.add(panel);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode implementar a autenticação do usuário.
                // Para fins de exemplo, vamos simplesmente abrir o MenuPrincipal.
                
                // Simulação de autenticação bem-sucedida
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                if (autenticar(usuario, senha)) {
                    new MenuPrincipal().setVisible(true); // Exibe o menu principal.
                    frame.dispose(); // Fecha a tela de login.
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private static boolean autenticar(String usuario, String senha) {
        // Implementar lógica de autenticação real aqui.
        // Para fins de exemplo, vamos aceitar qualquer usuário e senha não vazios.
        return !usuario.isEmpty() && !senha.isEmpty();
    }
}
