package com.example.ac2_ma.services;

import java.util.List;

import com.example.ac2_ma.dto.FuncionarioDTO;
import com.example.ac2_ma.dto.ProjetoDTO;

public interface FuncionarioService {
    void adicionar(FuncionarioDTO funcionarioDTO);

    List<ProjetoDTO> buscarProjetos(Integer idFuncionario);
}
