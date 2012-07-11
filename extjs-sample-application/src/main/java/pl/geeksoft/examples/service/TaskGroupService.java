package pl.geeksoft.examples.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.geeksoft.examples.model.TaskGroup;

import com.google.common.collect.Lists;

@Path("/task-group")
public class TaskGroupService {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskGroup> getTasksList() {
		List<TaskGroup> taskGroups = Lists.newArrayList();
		taskGroups.add(prepareTaskGroup(1L, "Shopping list"));
		taskGroups.add(prepareTaskGroup(2L, "At work"));
		taskGroups.add(prepareTaskGroup(3L, "At home"));
		return taskGroups;
	}

	private TaskGroup prepareTaskGroup(Long id, String name) {
		TaskGroup taskGroup = new TaskGroup();
		taskGroup.setId(id);
		taskGroup.setName(name);
		return taskGroup;
	}

}
