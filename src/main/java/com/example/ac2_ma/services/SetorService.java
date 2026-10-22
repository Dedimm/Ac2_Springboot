package com.example.ac2_ma.services;

import com.example.ac2_ma.dto.SetorDTO;

public interface SetorService {
    void adicionar(SetorDTO setorDTO);

    SetorDTO buscarSetorPorId(Integer idSetor);
}
