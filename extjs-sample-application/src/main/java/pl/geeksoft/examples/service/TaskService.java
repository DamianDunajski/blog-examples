package pl.geeksoft.examples.service;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.geeksoft.examples.model.Task;
import pl.geeksoft.examples.service.base.BaseService;

@ManagedBean
@Path("/task")
public class TaskService extends BaseService {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Task> getTasksList() {
		return this.entityManager.createQuery("SELECT t FROM Task t ORDER BY t.id", Task.class).getResultList();
	}

}
