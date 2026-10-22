package com.example.ac2_ma.dto;

import java.util.List;

import com.example.ac2_ma.models.Setor;

public class SetorDTO {
    private Integer id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;

    public SetorDTO() {
    }

    public SetorDTO(Integer id, String nome, List<FuncionarioDTO> funcionarios) {
        this.id = id;
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public static SetorDTO from(Setor s) {
        return new SetorDTO(s.getId(), s.getNome(),
                s.getFuncionarios().stream().map(FuncionarioDTO::from).toList());
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<FuncionarioDTO> getFuncionarios() { return funcionarios; }
    public void setFuncionarios(List<FuncionarioDTO> funcionarios) { this.funcionarios = funcionarios; }
}
