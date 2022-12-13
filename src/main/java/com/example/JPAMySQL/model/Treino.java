package com.example.JPAMySQL.model;

import javax.persistence.*;

@Entity //Isso fala para o JPA - Hibernate fazer uma tabale no banco
public class Treino {
    @Id // diz para o banco que o atributo abaixo é um PK
    @GeneratedValue(strategy = GenerationType.AUTO)//auto_increment
    private Integer id;

    @Column(nullable = false)//coluna não pode ser nulla
    private String nomeTreino;

    @Column(nullable = false, unique = true)//Coluna email é unica e não nulla
    private Integer series;

    @Column(nullable = false)//coluna não pode ser nulla
    private Integer repeticoes;

    @Column(nullable = false)//coluna não pode ser nulla
    private Integer intervalo;

    @Column(length = 15)// Coluna abaixo é um varhcar(15)
    private String Observacao;


    public Treino() {
    }

    public Treino(Integer id, String nomeTreino, Integer series, Integer repeticoes, Integer intervalo, String observacao) {
        this.id = id;
        this.nomeTreino = nomeTreino;
        this.series = series;
        this.repeticoes = repeticoes;
        this.intervalo = intervalo;
        Observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Integer getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Integer intervalo) {
        this.intervalo = intervalo;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

}