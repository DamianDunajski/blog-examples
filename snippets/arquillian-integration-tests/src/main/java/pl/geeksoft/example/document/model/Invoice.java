package pl.geeksoft.example.document.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: Damian Dunajski
 * Date: 26.05.2013
 * Time: 19:15
 */
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
