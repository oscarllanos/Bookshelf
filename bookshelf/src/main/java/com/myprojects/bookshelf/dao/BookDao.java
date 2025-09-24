package com.myprojects.bookshelf.dao;

import com.myprojects.bookshelf.models.Book;

import java.util.List;

public interface BookDao {

    List<Book> getBooks(String userName);

    void deleteBook(Long id);

    void register(Book book);
}
