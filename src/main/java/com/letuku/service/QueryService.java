package com.letuku.service;

import com.letuku.entity.TodoUser;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class QueryService {

    @PersistenceContext(unitName = "myPU")
    private EntityManager entityManager;

    public TodoUser findTodoUserByEmail(String email) {
        return entityManager.createNamedQuery(TodoUser.FIND_TO_DO_BY_EMAIL, TodoUser.class).setParameter("email", email).getSingleResult();
    }
}
