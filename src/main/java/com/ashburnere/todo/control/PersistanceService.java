package com.ashburnere.todo.control;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@RequestScoped
public class PersistanceService {

	@PersistenceContext
	EntityManager em;

}
