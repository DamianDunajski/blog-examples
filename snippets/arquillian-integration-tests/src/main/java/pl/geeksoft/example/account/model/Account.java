package pl.geeksoft.example.account.model;

import java.util.Date;

/**
 * User: Damian Dunajski
 * Date: 25.05.2013
 * Time: 21:36
 */
public class Account {

	private Long   id;
	private String email;
	private String password;
	private Date   registrationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
}
