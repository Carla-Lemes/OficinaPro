package br.com.oficinapro.principal;

import javax.swing.SwingUtilities;
import br.com.oficinapro.ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}