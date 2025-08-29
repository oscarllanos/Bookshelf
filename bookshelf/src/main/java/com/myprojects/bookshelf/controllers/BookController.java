package com.myprojects.bookshelf.controllers;

import com.myprojects.bookshelf.models.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @RequestMapping(value = "book/{id}")
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

    @RequestMapping(value = "books")
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setId(1L);
        book.setTitle("El Juego del Ángel");
        book.setAuthor("Carlos Ruiz Zafón");
        book.setDescription("La historia de David Martin");
        book.setRead("Sí");
        book.setInBookshelf("Sí");
        books.add(book);

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("La Sombra del Viento");
        book2.setAuthor("Carlos Ruiz Zafón");
        book2.setDescription("La historia de Julian Carax");
        book2.setRead("Sí");
        book2.setInBookshelf("No");
        books.add(book2);

        Book book3 = new Book();
        book3.setId(3L);
        book3.setTitle("El Prisionero del Cielo");
        book3.setAuthor("Carlos Ruiz Zafón");
        book3.setDescription("La historia de Fermín Romero de Tormes");
        book3.setRead("Sí");
        book3.setInBookshelf("No");
        books.add(book3);

        return books;
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
