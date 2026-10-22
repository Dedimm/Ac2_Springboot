package com.example.ac2_ma.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ac2_ma.config.exceptions.RegraNegocioException;
import com.example.ac2_ma.dto.ProjetoDTO;
import com.example.ac2_ma.models.Funcionario;
import com.example.ac2_ma.models.Projeto;
import com.example.ac2_ma.repositories.FuncionarioRepository;
import com.example.ac2_ma.repositories.ProjetoRepository;

@Service
public class ProjetoServiceImpl implements ProjetoService {
    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public ProjetoServiceImpl(ProjetoRepository projetoRepository,
            FuncionarioRepository funcionarioRepository) {
        this.projetoRepository = projetoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    @Transactional
    public void adicionar(ProjetoDTO projetoDTO) {
        projetoRepository.save(new Projeto(null, projetoDTO.getDescricao(),
                projetoDTO.getDataInicio(), projetoDTO.getDataFim()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjetoDTO> listar() {
        return projetoRepository.findAll().stream()
                .map(ProjetoDTO::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProjetoDTO buscarProjetoPorId(Integer id) {
        Projeto projeto = projetoRepository.findByIdComFuncionarios(id)
                .orElseThrow(() -> new RegraNegocioException("Projeto não encontrado"));
        return ProjetoDTO.from(projeto);
    }

    @Override
    @Transactional
    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findByIdComFuncionarios(idProjeto)
                .orElseThrow(() -> new RegraNegocioException("Projeto não encontrado"));
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RegraNegocioException("Funcionário não encontrado"));

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }
}
