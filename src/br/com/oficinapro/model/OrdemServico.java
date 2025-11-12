package br.com.oficinapro.model;

import java.time.LocalDate;

public class OrdemServico {
    private int id;
    private Veiculo veiculo;
    private String descricaoProblema;
    private LocalDate dataAbertura;
    private String status;

    public OrdemServico(int id, Veiculo veiculo, String descricaoProblema, LocalDate dataAbertura, String status) {
        this.id = id;
        this.veiculo = veiculo;
        this.descricaoProblema = descricaoProblema;
        this.dataAbertura = dataAbertura;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
    public String getDescricaoProblema() { return descricaoProblema; }
    public void setDescricaoProblema(String descricaoProblema) { this.descricaoProblema = descricaoProblema; }
    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}