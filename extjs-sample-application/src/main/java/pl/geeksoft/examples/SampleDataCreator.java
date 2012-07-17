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
import pl.geeksoft.examples.model.base.BaseModel;
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
		TaskGroup inbox = persist(prepareTaskGroup(1L, "Inbox"));
		TaskGroup shoppingList = persist(prepareTaskGroup(2L, "Shopping list"));
		TaskGroup atHome = persist(prepareTaskGroup(3L, "At home"));
		TaskGroup atWork = persist(prepareTaskGroup(4L, "At work"));
		// create sample tasks
		persist(prepareTask(1L, "Buy some fruits", shoppingList, TaskPriority.NORMAL, null, null));
		persist(prepareTask(2L, "Write article for personal blog", atHome, TaskPriority.IMPORTANT, DATE_FORMATTER.parseDateTime("2012-06-11"), null));
		persist(prepareTask(3L, "Ask Claudia about project progress", atWork, TaskPriority.NORMAL, DATE_FORMATTER.parseDateTime("2012-06-15"), null));
		persist(prepareTask(4L, "Call to Tom Simson for help", inbox, TaskPriority.NORMAL, DATE_FORMATTER.parseDateTime("2012-06-12"), TIME_FORMATTER.parseDateTime("14:00")));
	}

	private TaskGroup prepareTaskGroup(Long id, String name) {
		TaskGroup taskGroup = new TaskGroup();
		taskGroup.setId(id);
		taskGroup.setName(name);
		return taskGroup;
	}

	private Task prepareTask(Long id, String name, TaskGroup group, TaskPriority priority, DateTime dueDate, DateTime dueTime) {
		Task task = new Task();
		task.setId(id);
		task.setName(name);
		task.setGroup(group);
		task.setPriority(priority);
		if (dueDate != null) {
			task.setDueDate(dueDate.toDate());
		}
		if (dueTime != null) {
			task.setReminder(dueTime.toDate());
		}
		return task;
	}

	private <T extends BaseModel> T persist(T model) {
		this.entityManager.persist(model);
		return model;
	}


}
