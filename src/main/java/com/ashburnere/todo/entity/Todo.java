package com.ashburnere.todo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "MY_TODO_TABLE")
public class Todo {

	// primary key, auto generation strategy to let the persistence provider decide
	// which to use
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "todo_task")
	private String task;
	private LocalDate dueDate;
	private LocalDate dateCreated;
	private boolean completed;
	private boolean archived;

	@ManyToOne
	private TodoUser todoUser; // unidirectional relationship from Todo to user

	// non persistent field, ignored by JPA
	@Transient
	private String myTransientProperty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public TodoUser getTodoUser() {
		return todoUser;
	}

	public void setTodoUser(TodoUser todoUser) {
		this.todoUser = todoUser;
	}

	public String getMyTransientProperty() {
		return myTransientProperty;
	}

	public void setMyTransientProperty(String myTransientProperty) {
		this.myTransientProperty = myTransientProperty;
	}
}
