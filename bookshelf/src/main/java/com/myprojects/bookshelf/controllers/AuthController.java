package com.myprojects.bookshelf.controllers;

import com.myprojects.bookshelf.dao.UserDao;
import com.myprojects.bookshelf.models.Book;
import com.myprojects.bookshelf.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public void login(@RequestBody User user){
        userDao.verificarCredenciales(user);
    }

}
