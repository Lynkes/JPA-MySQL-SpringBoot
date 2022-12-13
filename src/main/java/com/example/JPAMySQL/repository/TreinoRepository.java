package com.example.JPAMySQL.repository;

import com.example.JPAMySQL.model.Pessoa;
import com.example.JPAMySQL.model.Treino;
import org.springframework.data.repository.CrudRepository;
//CRUD Creat, Read, Update, Delete da minha classe Pessoa
public interface TreinoRepository extends CrudRepository<Treino, Integer> {

}
