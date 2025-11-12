package br.com.oficinapro.ui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField txtUsuario = new JTextField();
    private JPasswordField txtSenha = new JPasswordField();
    private JButton btnEntrar = new JButton("Entrar");

    public LoginFrame() {
        super("OficinaPro - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JPanel form = new JPanel(new GridLayout(4,1,6,6));
        form.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
        form.add(new JLabel("Usuário:"));
        form.add(txtUsuario);
        form.add(new JLabel("Senha:"));
        form.add(txtSenha);

        add(form, BorderLayout.CENTER);
        add(btnEntrar, BorderLayout.SOUTH);

        btnEntrar.addActionListener(e -> autenticar());
        getRootPane().setDefaultButton(btnEntrar);
    }

    private void autenticar() {
        new MenuFrame().setVisible(true);
        dispose();
    }
}