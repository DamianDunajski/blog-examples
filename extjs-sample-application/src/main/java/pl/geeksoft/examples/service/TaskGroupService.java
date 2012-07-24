package pl.geeksoft.examples.service;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.geeksoft.examples.model.TaskGroup;
import pl.geeksoft.examples.service.base.BaseService;

@ManagedBean
@Path("/task/groups")
public class TaskGroupService extends BaseService {

	public TaskGroup getDefault() {
		return this.entityManager.find(TaskGroup.class, 1L);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskGroup> findTaskGroupsList() {
		return this.entityManager.createQuery("SELECT tg FROM TaskGroup tg ORDER BY tg.id", TaskGroup.class).getResultList();
	}
}
