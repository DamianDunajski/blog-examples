package pl.geeksoft.examples.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import pl.geeksoft.examples.model.base.BaseModel;
import pl.geeksoft.examples.model.constant.TaskPriority;

@Entity
@Table(name = "task")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task extends BaseModel {

	@Column(name = "name", nullable = false)
	private String       name;
	@Enumerated(EnumType.STRING)
	@Column(name = "priority", nullable = false)
	private TaskPriority priority;
	@Temporal(TemporalType.DATE)
	@Column(name = "due_date", nullable = true)
	private Date         dueDate;
	@Temporal(TemporalType.TIME)
	@Column(name = "due_time", nullable = true)
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
