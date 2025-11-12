package br.com.oficinapro.ui;

import br.com.oficinapro.data.DataStore;
import br.com.oficinapro.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VeiculosFrame extends JFrame {
    private DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Placa","Marca","Modelo","Ano","Cliente"}, 0);
    private JTable table = new JTable(model);
    private JTextField txtPlaca = new JTextField();
    private JTextField txtMarca = new JTextField();
    private JTextField txtModelo = new JTextField();
    private JTextField txtAno = new JTextField();
    private JComboBox<Cliente> cbCliente = new JComboBox<>();

    public VeiculosFrame() {
        super("OficinaPro - Veículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 520);
        setLocationRelativeTo(null);
        JPanel root = new JPanel(new BorderLayout(10,10));
        root.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));

        root.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(0,2,8,8));
        form.add(new JLabel("Placa:"));
        form.add(txtPlaca);
        form.add(new JLabel("Marca:"));
        form.add(txtMarca);
        form.add(new JLabel("Modelo:"));
        form.add(txtModelo);
        form.add(new JLabel("Ano:"));
        form.add(txtAno);
        form.add(new JLabel("Cliente:"));
        form.add(cbCliente);

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnVoltar = new JButton("Voltar");
        form.add(btnAdicionar);
        form.add(btnVoltar);

        root.add(form, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(e -> adicionarVeiculo());
        btnVoltar.addActionListener(e -> { new MenuFrame().setVisible(true); dispose(); });

        add(root);
        carregarClientes();
        carregarTabela();
    }

    private void carregarClientes() {
        cbCliente.removeAllItems();
        for (Cliente c : DataStore.getClientes()) {
            cbCliente.addItem(c);
        }
    }

    private void carregarTabela() {
        model.setRowCount(0);
        List<Veiculo> veiculos = DataStore.getVeiculos();
        for (Veiculo v : veiculos) {
            model.addRow(new Object[]{ v.getId(), v.getPlaca(), v.getMarca(), v.getModelo(), v.getAno(), v.getCliente().getNome() });
        }
    }

    private void adicionarVeiculo() {
        String placa = txtPlaca.getText().trim();
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();
        String anoStr = txtAno.getText().trim();
        Cliente cliente = (Cliente) cbCliente.getSelectedItem();
        if (placa.isEmpty() || cliente == null) {
            JOptionPane.showMessageDialog(this, "Informe ao menos placa e cliente.");
            return;
        }
        int ano = 0;
        try { ano = Integer.parseInt(anoStr); } catch (Exception e) {}
        DataStore.addVeiculo(placa, marca, modelo, ano, cliente);
        txtPlaca.setText(""); txtMarca.setText(""); txtModelo.setText(""); txtAno.setText("");
        carregarTabela();
    }
}