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
@Path("/task-group")
public class TaskGroupService extends BaseService {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskGroup> getTaskGroupList() {
		return this.entityManager.createQuery("SELECT tg FROM TaskGroup tg", TaskGroup.class).getResultList();
	}

}
