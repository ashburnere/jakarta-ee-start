package com.ashburnere.todo.boundary;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ashburnere.todo.control.PersistenceService;
import com.ashburnere.todo.control.QueryService;
import com.ashburnere.todo.entity.Todo;

@Path("todo") // domain-name/context-path/resources/todo
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

	@Inject
	private QueryService queryService;

	@Inject
	private PersistenceService persistenceService;

	@Path("list") // domain-name/context-path/resources/todo/list GET
	@GET
	public List<Todo> getAllTodos() {
		return queryService.getAllTodos();
	}

	@Path("new") // domain-name/context-path/resources/todo/new?id=2 POST // QueryParam
	@POST
	public Response saveTodo(Todo todo, @QueryParam("id") Long userId) {

		Todo todoSaved = persistenceService.saveTodo(todo, userId);

		return Response.ok(todoSaved).build();
	}

	@Path("time") // domain-name/context-path/resources/todo/time
	@GET
	public LocalDateTime getTime() {
		return LocalDateTime.now();
	}

	@Path("timetext") // domain-name/context-path/resources/todo/timetext
	@GET
	public String getTimeString() {
		return LocalDateTime.now().toString();
	}

}
