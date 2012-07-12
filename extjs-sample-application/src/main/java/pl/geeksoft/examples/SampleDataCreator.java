package pl.geeksoft.examples;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import pl.geeksoft.examples.model.Task;
import pl.geeksoft.examples.model.TaskGroup;
import pl.geeksoft.examples.model.constant.TaskPriority;

@Startup
@Singleton
public class SampleDataCreator {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm");

	@PersistenceContext(unitName = "master")
	private EntityManager entityManager;

	@PostConstruct
	public void createSampleData() {
		// create sample task groups
		this.entityManager.persist(prepareTaskGroup(1L, "Shopping list"));
		this.entityManager.persist(prepareTaskGroup(2L, "At work"));
		this.entityManager.persist(prepareTaskGroup(3L, "At home"));
		// create sample tasks
		this.entityManager.persist(prepareTask(1L, "Buy some fruits", TaskPriority.NORMAL, null, null));
		this.entityManager.persist(prepareTask(2L, "Write article for company blog", TaskPriority.IMPORTANT, DATE_FORMATTER.parseDateTime("2012-06-11"), null));
		this.entityManager.persist(prepareTask(3L, "Call to Tom Simson for help", TaskPriority.NORMAL, DATE_FORMATTER.parseDateTime("2012-06-12"), TIME_FORMATTER.parseDateTime("14:00")));
		this.entityManager.persist(prepareTask(4L, "Ask Claudia about project progress", TaskPriority.NORMAL, DATE_FORMATTER.parseDateTime("2012-06-15"), null));
	}

	private TaskGroup prepareTaskGroup(Long id, String name) {
		TaskGroup taskGroup = new TaskGroup();
		taskGroup.setId(id);
		taskGroup.setName(name);
		return taskGroup;
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
