package com.example.ac2_ma.dto;

import com.example.ac2_ma.models.Funcionario;

public class FuncionarioDTO {
    private Integer id;
    private String nome;
    private Integer idSetor;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Integer id, String nome, Integer idSetor) {
        this.id = id;
        this.nome = nome;
        this.idSetor = idSetor;
    }

    public static FuncionarioDTO from(Funcionario f) {
        return new FuncionarioDTO(f.getId(), f.getNome(),
                f.getSetor() != null ? f.getSetor().getId() : null);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getIdSetor() { return idSetor; }
    public void setIdSetor(Integer idSetor) { this.idSetor = idSetor; }
}
