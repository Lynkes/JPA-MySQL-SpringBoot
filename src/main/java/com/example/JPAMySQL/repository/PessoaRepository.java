package com.example.JPAMySQL.repository;

import com.example.JPAMySQL.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
//CRUD Creat, Read, Update, Delete da minha classe Pessoa
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

}
