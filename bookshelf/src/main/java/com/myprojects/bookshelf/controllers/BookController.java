package com.myprojects.bookshelf.controllers;

import com.myprojects.bookshelf.dao.BookDao;
import com.myprojects.bookshelf.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;


    @RequestMapping(value = "api/books", method = RequestMethod.GET)
    public List<Book> getBooks(){
        return bookDao.getBooks();
    }

    @RequestMapping(value = "api/books", method = RequestMethod.POST)
    public void registerBook(@RequestBody Book book){
        bookDao.register(book);
    }

    @RequestMapping(value = "api/books/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Long id){
        bookDao.deleteBook(id);
    }

}
