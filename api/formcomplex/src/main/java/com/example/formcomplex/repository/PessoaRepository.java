package com.example.formcomplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.formcomplex.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
