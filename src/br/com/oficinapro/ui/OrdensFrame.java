package br.com.oficinapro.ui;

import br.com.oficinapro.data.DataStore;
import br.com.oficinapro.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class OrdensFrame extends JFrame {
    private DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Placa","Modelo","Descrição","Status"}, 0);
    private JTable table = new JTable(model);
    private JComboBox<Veiculo> cbVeiculo = new JComboBox<>();
    private JTextField txtDescricao = new JTextField();

    public OrdensFrame() {
        super("OficinaPro - Ordens de Serviço");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 520);
        setLocationRelativeTo(null);
        JPanel root = new JPanel(new BorderLayout(10,10));
        root.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));

        root.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(0,2,8,8));
        form.add(new JLabel("Veículo:"));
        form.add(cbVeiculo);
        form.add(new JLabel("Descrição do problema:"));
        form.add(txtDescricao);
        JButton btnAdicionar = new JButton("Abrir OS");
        JButton btnVoltar = new JButton("Voltar");
        form.add(btnAdicionar);
        form.add(btnVoltar);

        root.add(form, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(e -> adicionarOS());
        btnVoltar.addActionListener(e -> { new MenuFrame().setVisible(true); dispose(); });

        add(root);
        carregarVeiculos();
        carregarTabela();
    }

    private void carregarVeiculos() {
        cbVeiculo.removeAllItems();
        for (Veiculo v : DataStore.getVeiculos()) {
            cbVeiculo.addItem(v);
        }
    }

    private void carregarTabela() {
        model.setRowCount(0);
        List<OrdemServico> ordens = DataStore.getOrdens();
        for (OrdemServico os : ordens) {
            model.addRow(new Object[]{ os.getId(), os.getVeiculo().getPlaca(), os.getVeiculo().getModelo(), os.getDescricaoProblema(), os.getStatus() });
        }
    }

    private void adicionarOS() {
        Veiculo v = (Veiculo) cbVeiculo.getSelectedItem();
        String desc = txtDescricao.getText().trim();
        if (v == null || desc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo e informe a descrição.");
            return;
        }
        DataStore.addOS(v, desc);
        txtDescricao.setText("");
        carregarTabela();
    }
}