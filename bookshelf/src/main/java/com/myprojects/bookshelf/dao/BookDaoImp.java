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
    public List<Book> getBooks(String userName) {
        String query = "From Book WHERE userName = :userName";
        return entityManager.createQuery(query)
                .setParameter("userName", userName)
                .getResultList();
    }

    @Override
    public void deleteBook(Long id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }

    @Override
    public void register(Book book) {
        entityManager.merge(book);
    }
}
