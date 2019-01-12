package com.ashburnere.todo.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ashburnere.todo.entity.Todo;
import com.ashburnere.todo.entity.TodoUser;

@Transactional
@ApplicationScoped
public class QueryService {

	@PersistenceContext
	EntityManager em;

	public List<Todo> getAllTodos() {
		// query all Todo objects using JPQL
		return em.createQuery("select todo from Todo todo order by todo.dueDate", Todo.class).getResultList();
	}

	public List<Todo> getAllTodos(Long id) {
		List<Todo> todoList;
		TodoUser todoUser = findTodoUser(id);
		if (todoUser != null) {
			todoList = em.createQuery("select todo from Todo  todo where todo.todoUser = :user ", Todo.class)
					.setParameter("user", todoUser).getResultList();
			return todoList;
		}

		return null;
	}

	public List<TodoUser> getAllTodoUsers() {
		// query all TodoUser objects using name query from TodoUser class
		return em.createNamedQuery(TodoUser.GET_ALL_USERS, TodoUser.class).getResultList();
	}

	public Todo findTodo(long id) {
		return em.find(Todo.class, id);
	}

	public TodoUser findTodoUser(Long id) {
		return em.find(TodoUser.class, id);
	}
}
