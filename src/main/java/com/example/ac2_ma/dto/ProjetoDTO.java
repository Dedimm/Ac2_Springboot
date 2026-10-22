package com.example.ac2_ma.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.ac2_ma.models.Projeto;

public class ProjetoDTO {
    private Integer id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<FuncionarioDTO> funcionarios;

    public ProjetoDTO() {
    }

    public ProjetoDTO(Integer id, String descricao, LocalDate dataInicio, LocalDate dataFim,
            List<FuncionarioDTO> funcionarios) {
        this.id = id;
        this.nome = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.funcionarios = funcionarios;
    }

    public static ProjetoDTO from(Projeto p) {
        return new ProjetoDTO(p.getId(), p.getDescricao(), p.getDataInicio(), p.getDataFim(),
                p.getFuncionarios().stream().map(FuncionarioDTO::from).toList());
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescricao() { return nome; }
    public void setDescricao(String descricao) { this.nome = descricao; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public List<FuncionarioDTO> getFuncionarios() { return funcionarios; }
    public void setFuncionarios(List<FuncionarioDTO> funcionarios) { this.funcionarios = funcionarios; }
}
