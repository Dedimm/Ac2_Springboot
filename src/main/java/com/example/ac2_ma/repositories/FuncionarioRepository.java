package com.example.ac2_ma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac2_ma.models.Funcionario;
import com.example.ac2_ma.models.Projeto;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {


    @Query("""
            select distinct p from Projeto p
            left join fetch p.funcionarios
            where p.id in (
                select p2.id from Projeto p2
                join p2.funcionarios f
                where f.id = :idFuncionario
            )
            """)
    List<Projeto> findProjetosByFuncionarioId(@Param("idFuncionario") Integer idFuncionario);
}
