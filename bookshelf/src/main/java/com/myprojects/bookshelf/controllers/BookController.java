package com.myprojects.bookshelf.controllers;

import com.myprojects.bookshelf.models.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @RequestMapping(value = "book/{id}")
    public Book getBook(@PathVariable Long id){
        Book book = new Book();
        book.setId(id);
        book.setTitle("El Juego del Ángel");
        book.setAuthor("Carlos Ruiz Zafón");
        book.setDescription("La historia de David Martin");
        book.setRead(true);
        book.setInBookshelf(true);

        return book;
    }

    @RequestMapping(value = "book/search/{title}")
    public Book searchBook(@PathVariable String title){
        Book book = new Book();
        book.setId(1L);
        book.setTitle(title);
        book.setAuthor("Cralos Ruiz Zafón");
        book.setDescription("La historia de David Martin");
        book.setRead(true);
        book.setInBookshelf(true);

        return book;
    }

    @RequestMapping(value = "book/update")
    public Book updateBook(){
        Book book = new Book();
        book.setId(1L);
        book.setTitle("El Juego del Ángel");
        book.setAuthor("Cralos Ruiz Zafón");
        book.setDescription("La historia de David Martin");
        book.setRead(true);
        book.setInBookshelf(true);

        return book;
    }
}
