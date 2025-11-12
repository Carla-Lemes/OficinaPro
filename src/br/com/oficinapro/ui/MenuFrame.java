package br.com.oficinapro.ui;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    public MenuFrame() {
        super("OficinaPro - Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 300);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(0,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));

        JButton btnClientes = new JButton("Clientes");
        JButton btnVeiculos = new JButton("Veículos");
        JButton btnOrdens = new JButton("Ordens de Serviço");
        JButton btnSair = new JButton("Sair");

        panel.add(btnClientes);
        panel.add(btnVeiculos);
        panel.add(btnOrdens);
        panel.add(btnSair);

        btnClientes.addActionListener(e -> { new ClientesFrame().setVisible(true); dispose(); });
        btnVeiculos.addActionListener(e -> { new VeiculosFrame().setVisible(true); dispose(); });
        btnOrdens.addActionListener(e -> { new OrdensFrame().setVisible(true); dispose(); });
        btnSair.addActionListener(e -> System.exit(0));

        add(panel);
    }
}