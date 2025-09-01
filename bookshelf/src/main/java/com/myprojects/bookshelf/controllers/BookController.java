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

    @RequestMapping(value = "api/books/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id){
        Book book = new Book();
        book.setId(id);
        book.setTitle("El Juego del Ángel");
        book.setAuthor("Carlos Ruiz Zafón");
        book.setDescription("La historia de David Martin");
        book.setRead("Sí");
        book.setInBookshelf("Sí");

        return book;
    }

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

    @RequestMapping(value = "book/search/{title}")
    public Book searchBook(@PathVariable String title){
        Book book = new Book();
        book.setId(1L);
        book.setTitle(title);
        book.setAuthor("Carlos Ruiz Zafón");
        book.setDescription("La historia de David Martin");
        book.setRead("Sí");
        book.setInBookshelf("No");

        return book;
    }

    @RequestMapping(value = "book/update")
    public Book updateBook(){
        Book book = new Book();
        book.setId(1L);
        book.setTitle("El Juego del Ángel");
        book.setAuthor("Carlos Ruiz Zafón");
        book.setDescription("La historia de David Martin");
        book.setRead("Sí");
        book.setInBookshelf("Sí");

        return book;
    }
}
