package com.letuku.service;

import com.letuku.entity.Todo;
import com.letuku.entity.TodoUser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersistenceService {

    @PersistenceContext(unitName = "myPU")
    private EntityManager entityManager;

    @Inject
    private MySession mySession;

    @Inject
    private QueryService queryService;

    public TodoUser saveTodoUser(TodoUser todoUser) {
        if (todoUser.getId() != null) {
            entityManager.merge(todoUser);
        } else {
            entityManager.persist(todoUser);
        }
        return todoUser;
    }

    public Todo saveTodo(Todo todo){

        String email = mySession.getEmail();
        TodoUser todoUser = queryService.findTodoUserByEmail(email);

        if (todo.getId() != null && todoUser != null){
            todo.setTodoOwner(todoUser);
            entityManager.merge(todo);
        } else {
            entityManager.persist(todo);
        }
        
        return todo;
    }
}
