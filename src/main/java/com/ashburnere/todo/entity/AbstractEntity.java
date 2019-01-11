package com.ashburnere.todo.entity;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

	// primary key, auto generation strategy to let the persistence provider decide
	// which to use
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	protected LocalDate createdOn;
	protected LocalDate editedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getEditedOn() {
		return editedOn;
	}

	public void setEditedOn(LocalDate editedOn) {
		this.editedOn = editedOn;
	}

}
