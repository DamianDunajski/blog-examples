package pl.geeksoft.examples.service;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.geeksoft.examples.model.Task;
import pl.geeksoft.examples.model.constant.TaskPriority;
import pl.geeksoft.examples.service.base.BaseService;

@ManagedBean
@Path("/tasks")
public class TaskService extends BaseService {

	private static final Logger log = LoggerFactory.getLogger(TaskService.class);

	@Resource
	private TaskGroupService taskGroupService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Task> findTasksList() {
		return this.entityManager.createQuery("SELECT t FROM Task t ORDER BY t.id", Task.class).getResultList();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createTask(Task task) {
		System.out.println("TaskService.createTask");
		System.out.println("task = " + task);
		task.setGroup(this.taskGroupService.getDefault());
		task.setPriority(TaskPriority.NORMAL);
		try {
			beginTransaction();
			this.entityManager.persist(task);
			commitTransaction();
		} catch (PersistenceException ex) {
			log.error(ex.getMessage(), ex);
			rollbackTransaction();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Task getTask(@PathParam("id") Long id) {
		return this.entityManager.find(Task.class, id);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateTask(@PathParam("id") Long id, Task task) {
		System.out.println("TaskService.updateTask");
		System.out.println("id = " + id);
		System.out.println("task = " + task);
		try {
			beginTransaction();
			this.entityManager.merge(task);
			commitTransaction();
		} catch (PersistenceException ex) {
			log.error(ex.getMessage(), ex);
			rollbackTransaction();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeTask(@PathParam("id") Long id, Task task) {
		System.out.println("TaskService.removeTask");
		System.out.println("id = " + id);
		System.out.println("task = " + task);
		try {
			beginTransaction();
			this.entityManager.remove(this.entityManager.merge(task));
			commitTransaction();
		} catch (PersistenceException ex) {
			log.error(ex.getMessage(), ex);
			rollbackTransaction();
		}
	}

}
