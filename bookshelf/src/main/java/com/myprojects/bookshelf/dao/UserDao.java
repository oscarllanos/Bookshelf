package com.myprojects.bookshelf.dao;

import com.myprojects.bookshelf.models.User;

public interface UserDao {
    boolean verificarCredenciales(User user);
}
