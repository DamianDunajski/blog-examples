package pl.geeksoft.examples.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import pl.geeksoft.examples.model.base.BaseModel;
import pl.geeksoft.examples.model.constant.TaskPriority;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task extends BaseModel {

	private String       name;
	private TaskPriority priority;
	private Date         dueDate;
	private Date         dueTime;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskPriority getPriority() {
		return this.priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDueTime() {
		return this.dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}
}
