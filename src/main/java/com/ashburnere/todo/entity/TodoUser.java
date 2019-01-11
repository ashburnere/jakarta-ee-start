package com.ashburnere.todo.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = TodoUser.GET_ALL_USERS, query = "select user from TodoUser user order by user.name")
public class TodoUser extends AbstractEntity {

	private String name;
	private String email;

	public static final String GET_ALL_USERS = "TodoUser.getAllUsers";

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
