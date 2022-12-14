package com.example.AcademiaWeb_App.service;

import com.example.AcademiaWeb_App.dto.UserDto;
import com.example.AcademiaWeb_App.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
