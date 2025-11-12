package br.com.oficinapro.ui;


import br.com.oficinapro.dao.ClienteDAO;
import br.com.oficinapro.model.Cliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ClientesFrame extends JFrame {

    private DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Nome","CPF","Telefone","Email"}, 0);
    private JTable table = new JTable(model);
    private JTextField txtNome = new JTextField();
    private JTextField txtCPF = new JTextField();
    private JTextField txtTelefone = new JTextField();
    private JTextField txtEmail = new JTextField();

    public ClientesFrame() {
        super("OficinaPro - Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 480);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout(10,10));
        root.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        root.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(0,2,8,8));
        form.add(new JLabel("Nome:"));
        form.add(txtNome);
        form.add(new JLabel("CPF:"));
        form.add(txtCPF);
        form.add(new JLabel("Telefone:"));
        form.add(txtTelefone);
        form.add(new JLabel("Email:"));
        form.add(txtEmail);

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnVoltar = new JButton("Voltar");
        form.add(btnAdicionar);
        form.add(btnVoltar);

        root.add(form, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(e -> adicionarCliente());
        btnVoltar.addActionListener(e -> { new MenuFrame().setVisible(true); dispose(); });

        add(root);
        carregarTabela();
    }

    private void carregarTabela() {
        model.setRowCount(0);
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.listar();
        for (Cliente c : clientes) {
            model.addRow(new Object[]{ c.getId(), c.getNome(), c.getCpf(), c.getTelefone(), c.getEmail() });
        }
    }

    private void adicionarCliente() {
        String nome = txtNome.getText().trim();
        String cpf = txtCPF.getText().trim();
        String tel = txtTelefone.getText().trim();
        String email = txtEmail.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome.");
            return;
        }

        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.setTelefone(tel);
        c.setEmail(email);

        ClienteDAO dao = new ClienteDAO();
        dao.inserir(c);

        txtNome.setText("");
        txtCPF.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");

        carregarTabela();
    }
}