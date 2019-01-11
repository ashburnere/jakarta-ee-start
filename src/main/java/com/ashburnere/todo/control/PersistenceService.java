package com.ashburnere.todo.control;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ashburnere.todo.entity.Todo;
import com.ashburnere.todo.entity.TodoUser;

@Transactional
@RequestScoped
public class PersistenceService {

	@PersistenceContext
	EntityManager em;

	public TodoUser saveTodoUser(TodoUser user) {
		em.persist(user);

		return user;
	}

	public TodoUser updateTodoUser(TodoUser user) {
		em.merge(user);

		return user;
	}

	public Todo saveTodo(Todo todo) {
		em.persist(todo);

		return todo;
	}

	public Todo updateTodo(Todo todo) {
		em.merge(todo);

		return todo;
	}

}
