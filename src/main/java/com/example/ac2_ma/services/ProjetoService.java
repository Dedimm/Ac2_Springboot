package com.example.ac2_ma.services;

import java.util.List;

import com.example.ac2_ma.dto.ProjetoDTO;

public interface ProjetoService {
    void adicionar(ProjetoDTO projetoDTO);

    List<ProjetoDTO> listar();

    ProjetoDTO buscarProjetoPorId(Integer id);

    void vincularFuncionario(Integer idProjeto, Integer idFuncionario);
}
