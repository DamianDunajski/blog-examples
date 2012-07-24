package pl.geeksoft.examples.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;

import pl.geeksoft.examples.model.base.BaseModel;
import pl.geeksoft.examples.model.constant.TaskPriority;

@Entity
@Table(name = "task")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task extends BaseModel {

	@Column(name = "name", nullable = false)
	private String       name;
	@ManyToOne
	@JoinColumn(name = "group_fkey", nullable = false)
	private TaskGroup    group;
	@Enumerated(EnumType.STRING)
	@Column(name = "priority", nullable = false)
	private TaskPriority priority;
	@Temporal(TemporalType.DATE)
	@Column(name = "due_date", nullable = true)
	private Date         dueDate;
	@Temporal(TemporalType.TIME)
	@Column(name = "reminder", nullable = true)
	private Date         reminder;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskGroup getGroup() {
		return this.group;
	}

	public void setGroup(TaskGroup group) {
		this.group = group;
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

	public Date getReminder() {
		return this.reminder;
	}

	public void setReminder(Date reminder) {
		this.reminder = reminder;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.appendSuper(super.toString());
		builder.append("name", this.name);
		builder.append("group", this.group);
		builder.append("priority", this.priority);
		builder.append("dueDate", this.dueDate);
		builder.append("reminder", this.reminder);
		return builder.toString();
	}
}
