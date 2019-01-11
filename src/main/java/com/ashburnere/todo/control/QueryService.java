package com.ashburnere.todo.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ashburnere.todo.entity.Todo;

@Transactional
@ApplicationScoped
public class QueryService {

	@PersistenceContext
	EntityManager em;

	public List<Todo> getAllTodos() {
		// query all Todo objects using JPQL
		return em.createQuery("select todo from Todo todo order by todo.dueDate", Todo.class).getResultList();
	}
}
