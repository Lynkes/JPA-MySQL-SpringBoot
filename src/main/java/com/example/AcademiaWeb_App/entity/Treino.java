package com.example.AcademiaWeb_App.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="treino")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nomeTreino;

    @Column(nullable = false, unique = true)
    private Integer series;

    @Column(nullable = false)
    private Integer repeticoes;

    @Column(nullable = false)
    private Integer intervalo;

    @Column(length = 15)
    private String Observacao;


}