package com.ashburnere.todo.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ashburnere.todo.control.PersistenceService;
import com.ashburnere.todo.control.QueryService;
import com.ashburnere.todo.entity.Todo;
import com.ashburnere.todo.entity.TodoUser;

@Path("todo-user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoUserResource {

	@Inject
	private QueryService queryService;
	@Inject
	private PersistenceService persistenceService;

	@POST // domain-name/context-path/resources/todo-user/ - POST METHOD
	public Response saveTodoUser(TodoUser todoUser) {

		TodoUser todoUser1 = persistenceService.saveTodoUser(todoUser);

		return Response.ok(todoUser1).build();
	}

	@Path("all/{id}")
	@GET // domain-name/context-path/resources/todo-user/all/2 - GET METHOD with
			// PathParam
	public Response getAllTodos(@PathParam("id") Long id) {
		List<Todo> allTodos = queryService.getAllTodos(id);

		return Response.ok(allTodos).build();
	}

}
