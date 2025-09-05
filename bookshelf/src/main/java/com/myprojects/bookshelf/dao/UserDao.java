package com.myprojects.bookshelf.dao;

import com.myprojects.bookshelf.models.Book;
import com.myprojects.bookshelf.models.User;

public interface UserDao {
    void verificarCredenciales(User user);
}
