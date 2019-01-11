package com.ashburnere.todo.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TodoUser {

	// primary key, auto generation strategy to let the persistence provider decide
	// which to use
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String email;

	@OneToMany
	private Collection<Todo> todoCollection = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Todo> getTodoCollection() {
		return todoCollection;
	}

	public void setTodoCollection(Collection<Todo> todoCollection) {
		this.todoCollection = todoCollection;
	}

}
