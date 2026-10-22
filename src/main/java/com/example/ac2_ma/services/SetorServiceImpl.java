package com.example.ac2_ma.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ac2_ma.config.exceptions.RegraNegocioException;
import com.example.ac2_ma.dto.SetorDTO;
import com.example.ac2_ma.models.Setor;
import com.example.ac2_ma.repositories.SetorRepository;

@Service
public class SetorServiceImpl implements SetorService {
    private final SetorRepository setorRepository;

    public SetorServiceImpl(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    @Override
    @Transactional
    public void adicionar(SetorDTO setorDTO) {
        setorRepository.save(new Setor(null, setorDTO.getNome()));
    }

    @Override
    @Transactional(readOnly = true)
    public SetorDTO buscarSetorPorId(Integer idSetor) {
        Setor setor = setorRepository.findByIdComFuncionarios(idSetor)
                .orElseThrow(() -> new RegraNegocioException("Setor não encontrado"));
        return SetorDTO.from(setor);
    }
}
