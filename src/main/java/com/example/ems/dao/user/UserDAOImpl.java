package com.example.ems.dao.user;

import com.example.ems.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDAOImpl implements UserDAO{

    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u " +
                "where u.email = :email", User.class);
        query.setParameter("email", email);
        User theUser = query.getSingleResult();
        if(theUser == null) {
            return null;
        }
        return theUser;
    }

    @Override
    public User deleteUserByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u " +
                "where u.email = :email", User.class);
        query.setParameter("email", email);
        User theUser = query.getSingleResult();
        if(theUser == null) {
            return null;
        }
        entityManager.remove(email);
        return theUser;
    }
}
