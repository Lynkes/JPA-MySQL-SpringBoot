package com.example.JPAMySQL.model;

import javax.persistence.*;

@Entity //Isso fala para o JPA - Hibernate fazer uma tabale no banco
public class Pessoa {
    @Id // diz para o banco que o atributo abaixo é um PK
    @GeneratedValue(strategy = GenerationType.AUTO)//auto_increment
    private Integer id;

    @Column(nullable = false)//coluna não pode ser nulla
    private String nome;

    @Column(nullable = false, unique = true)//Coluna email é unica e não nulla
    private String email;

    @Column(length = 15)// Coluna abaixo é um varhcar(15)
    private String fone;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String email, String fone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
