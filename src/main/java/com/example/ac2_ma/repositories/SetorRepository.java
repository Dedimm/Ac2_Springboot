package com.example.ac2_ma.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac2_ma.models.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer> {

    
    @Query("select distinct s from Setor s left join fetch s.funcionarios")
    List<Setor> findAllComFuncionarios();

    @Query("select s from Setor s left join fetch s.funcionarios where s.id = :id")
    Optional<Setor> findByIdComFuncionarios(@Param("id") Integer id);
}
