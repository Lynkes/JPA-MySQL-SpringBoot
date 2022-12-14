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
@Table(name="equipamento")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//auto_increment
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 100)
    private String exercicios;


}