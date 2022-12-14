package com.example.AcademiaWeb_App.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    @Column(length = 13, unique=true) //5555996639240
    private String phone;
    @Column(length = 14, unique=true)//000.000.000-00
    private String cpf;
    @Column(length = 100)
    private String end;

    private Date birth;
    @Column(length = 100)
    private String obs;
}
