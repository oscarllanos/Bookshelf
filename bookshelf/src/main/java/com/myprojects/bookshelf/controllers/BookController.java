package com.myprojects.bookshelf.controllers;

import com.myprojects.bookshelf.dao.BookDao;
import com.myprojects.bookshelf.models.Book;
import com.myprojects.bookshelf.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/books/{userName}", method = RequestMethod.GET)
    public List<Book> getBooks(@RequestHeader(value="Authorization") String token,
                               @PathVariable String userName){
        if (!validarToken(token)){
            return null;
        }

        return bookDao.getBooks(userName);
    }

    @RequestMapping(value = "api/books", method = RequestMethod.POST)
    public void registerBook(@RequestHeader(value = "Authorization") String token,
                             @RequestBody Book book){
        if (!validarToken(token)){
            return;
        }
        bookDao.register(book);
    }

    @RequestMapping(value = "api/books/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@RequestHeader(value="Authorization") String token,
                           @PathVariable Long id){
        if (!validarToken(token)){
            return;
        }
        bookDao.deleteBook(id);
    }

    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

}
