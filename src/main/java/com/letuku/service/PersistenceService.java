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
        if (todoUser.getId() != null) {
            entityManager.merge(todoUser);
        } else {
            entityManager.persist(todoUser);
        }
        return todoUser;
    }

    public Todo saveTodo(Todo todo){
        if (todo.getId() != null){
            entityManager.merge(todo);
        } else {
            entityManager.persist(todo);
        }
        return todo;
    }
}
