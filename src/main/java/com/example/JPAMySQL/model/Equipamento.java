package com.example.JPAMySQL.model;

import javax.persistence.*;

@Entity //Isso fala para o JPA - Hibernate fazer uma tabale no banco
public class Equipamento {
    @Id // diz para o banco que o atributo abaixo é um PK
    @GeneratedValue(strategy = GenerationType.AUTO)//auto_increment
    private Integer id;

    @Column(nullable = false)//coluna não pode ser nulla
    private String nome;

    @Column(length = 100)// Coluna abaixo é um varhcar(100)
    private String exercicios;

    public Equipamento() {
    }

    public Equipamento(Integer id, String nome, String exercicios) {
        this.id = id;
        this.nome = nome;
        this.exercicios = exercicios;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getexercicios() {return exercicios;}

    public void setexercicios(String exercicios) {this.exercicios = exercicios;}
}
