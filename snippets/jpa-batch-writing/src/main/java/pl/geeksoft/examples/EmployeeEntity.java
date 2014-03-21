package pl.geeksoft.examples;

import static javax.persistence.GenerationType.TABLE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = TABLE)
	@Column(name = "id", nullable = false)
	private Long   id;
	@Column(name = "name", nullable = false)
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remove_time", nullable = true)
	private Date   removeTime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRemoveTime() {
		return this.removeTime;
	}

	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
}
