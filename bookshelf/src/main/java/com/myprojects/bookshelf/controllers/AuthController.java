package com.myprojects.bookshelf.controllers;

import com.myprojects.bookshelf.dao.UserDao;
import com.myprojects.bookshelf.models.Book;
import com.myprojects.bookshelf.models.User;
import com.myprojects.bookshelf.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public ArrayList<String> login(@RequestBody User user) {

        User usuarioLogueado = userDao.obtenerUsuarioPorCredenciales(user);

        ArrayList<String> datos = new ArrayList<>();

        if (usuarioLogueado != null){
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            datos.add(usuarioLogueado.getNombre());
            datos.add(tokenJwt);
            return datos;
        };

        return datos;
    }
}


