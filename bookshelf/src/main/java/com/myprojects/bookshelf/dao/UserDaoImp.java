package com.myprojects.bookshelf.dao;

import com.myprojects.bookshelf.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean verificarCredenciales(User user) {
        String query = "From User WHERE email = :email AND password = :password";
        List<User> lista = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();

        return !lista.isEmpty();
    }
}
