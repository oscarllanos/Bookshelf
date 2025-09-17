package com.myprojects.bookshelf.dao;

import com.myprojects.bookshelf.models.User;

public interface UserDao {
    User obtenerUsuarioPorCredenciales(User user);

    void registerUser(User user);
}
