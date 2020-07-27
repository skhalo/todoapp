package com.letuku.service;

import com.letuku.entity.Todo;
import com.letuku.entity.TodoUser;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersistenceService {

    @PersistenceContext(unitName = "myPU")
    private EntityManager entityManager;

    public TodoUser saveTodoUser(TodoUser todoUser) {
        entityManager.persist(todoUser);
        return todoUser;
    }

    public Todo saveTodo(Todo todo){
        entityManager.persist(todo);
        return todo;
    }
}
