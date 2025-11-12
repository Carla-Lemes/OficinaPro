package br.com.oficinapro.data;

import br.com.oficinapro.model.*;
import java.util.*;
import java.time.LocalDate;

public class DataStore {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Veiculo> veiculos = new ArrayList<>();
    private static final List<OrdemServico> ordens = new ArrayList<>();
    private static int clienteSeq = 1;
    private static int veiculoSeq = 1;
    private static int osSeq = 1;

    static {
        Cliente c1 = new Cliente(clienteSeq++, "João Silva", "123.456.789-00", "11 99999-8888", "joao@email.com");
        Cliente c2 = new Cliente(clienteSeq++, "Maria Souza", "987.654.321-00", "11 98888-7777", "maria@email.com");
        clientes.add(c1);
        clientes.add(c2);
        Veiculo v1 = new Veiculo(veiculoSeq++, "ABC-1234", "Fiat", "Uno", 2012, c1);
        Veiculo v2 = new Veiculo(veiculoSeq++, "DEF-5678", "VW", "Gol", 2015, c2);
        veiculos.add(v1);
        veiculos.add(v2);
        ordens.add(new OrdemServico(osSeq++, v1, "Troca de óleo", LocalDate.now(), "Aberta"));
    }

    public static List<Cliente> getClientes() { return clientes; }
    public static List<Veiculo> getVeiculos() { return veiculos; }
    public static List<OrdemServico> getOrdens() { return ordens; }

    public static Cliente addCliente(String nome, String cpf, String telefone, String email) {
        Cliente c = new Cliente(clienteSeq++, nome, cpf, telefone, email);
        clientes.add(c);
        return c;
    }

    public static Veiculo addVeiculo(String placa, String marca, String modelo, int ano, Cliente dono) {
        Veiculo v = new Veiculo(veiculoSeq++, placa, marca, modelo, ano, dono);
        veiculos.add(v);
        return v;
    }

    public static OrdemServico addOS(Veiculo veiculo, String descricao) {
        OrdemServico os = new OrdemServico(osSeq++, veiculo, descricao, LocalDate.now(), "Aberta");
        ordens.add(os);
        return os;
    }
}