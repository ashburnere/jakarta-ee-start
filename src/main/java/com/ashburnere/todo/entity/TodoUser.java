package com.ashburnere.todo.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@SuppressWarnings("unused")
@Entity
public class TodoUser extends AbstractEntity {

	private String name;
	private String email;

	@OneToMany
	private Collection<Todo> todoCollection = new ArrayList<>();

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
