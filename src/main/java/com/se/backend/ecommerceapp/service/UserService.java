package com.se.backend.ecommerceapp.service;

import java.util.List;

import com.se.backend.ecommerceapp.model.entity.User;

public interface UserService {

	User findUser(Long id);
    List<User> findAll();
    User save(User user);
    User update(User user);
    void delete(User user);
}
