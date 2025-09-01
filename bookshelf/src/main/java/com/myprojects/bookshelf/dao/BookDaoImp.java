package com.myprojects.bookshelf.dao;

import com.myprojects.bookshelf.models.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookDaoImp implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getBooks() {
        String query = "From Book";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteBook(Long id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }
}
