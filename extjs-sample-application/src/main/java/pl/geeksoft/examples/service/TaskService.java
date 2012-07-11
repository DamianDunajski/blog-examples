package pl.geeksoft.examples.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import pl.geeksoft.examples.model.Task;
import pl.geeksoft.examples.model.constant.TaskPriority;

import com.google.common.collect.Lists;

@Path("/task")
public class TaskService {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm");

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Task> getTasksList() {
		List<Task> tasks = Lists.newArrayList();
		tasks.add(prepareTask(1L, "Buy some fruits", TaskPriority.NORMAL, null, null));
		tasks.add(prepareTask(2L, "Write article for company blog", TaskPriority.IMPORTANT, DATE_FORMATTER.parseDateTime("2012-06-11"), null));
		tasks.add(prepareTask(3L, "Call to Tom Simson for help", TaskPriority.NORMAL, DATE_FORMATTER.parseDateTime("2012-06-12"), TIME_FORMATTER.parseDateTime("14:00")));
		tasks.add(prepareTask(4L, "Ask Claudia about project progress", TaskPriority.NORMAL, DATE_FORMATTER.parseDateTime("2012-06-15"), null));
		return tasks;
	}

	private Task prepareTask(Long id, String name, TaskPriority priority, DateTime dueDate, DateTime dueTime) {
		Task task = new Task();
		task.setId(id);
		task.setName(name);
		task.setPriority(priority);
		if (dueDate != null) {
			task.setDueDate(dueDate.toDate());
		}
		if (dueTime != null) {
			task.setDueTime(dueTime.toDate());
		}
		return task;
	}

}
