package com.example.ac2_ma.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ac2_ma.config.exceptions.RegraNegocioException;
import com.example.ac2_ma.dto.FuncionarioDTO;
import com.example.ac2_ma.dto.ProjetoDTO;
import com.example.ac2_ma.models.Funcionario;
import com.example.ac2_ma.models.Setor;
import com.example.ac2_ma.repositories.FuncionarioRepository;
import com.example.ac2_ma.repositories.SetorRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository,
            SetorRepository setorRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.setorRepository = setorRepository;
    }

    @Override
    @Transactional
    public void adicionar(FuncionarioDTO funcionarioDTO) {
        Setor setor = setorRepository.findById(funcionarioDTO.getIdSetor())
                .orElseThrow(() -> new RegraNegocioException("Setor não encontrado"));
        funcionarioRepository.save(new Funcionario(null, funcionarioDTO.getNome(), setor));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjetoDTO> buscarProjetos(Integer idFuncionario) {
        funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RegraNegocioException("Funcionário não encontrado"));
        return funcionarioRepository.findProjetosByFuncionarioId(idFuncionario).stream()
                .map(ProjetoDTO::from)
                .toList();
    }
}
