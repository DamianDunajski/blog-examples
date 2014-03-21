package pl.geeksoft.examples;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeePersistenceBeanTest {

	public static final String DEFAULT_ECLIPSELINK_POSTGRESQL = "default-eclipselink-postgresql";
	public static final String DEFAULT_HIBERNATE_POSTGRESQL   = "default-hibernate-postgresql";

	private EntityManager entityManager;

	private EmployeePersistenceBean bean;

	@Before
	public void init() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DEFAULT_HIBERNATE_POSTGRESQL);
		this.entityManager = entityManagerFactory.createEntityManager();

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(createEmployee("Al"));
		this.entityManager.persist(createEmployee("Bob"));
		this.entityManager.persist(createEmployee("Carl"));
		this.entityManager.getTransaction().commit();

		this.bean = new EmployeePersistenceBean();
		this.bean.setEntityManager(this.entityManager);
	}

	@After
	public void cleanUp() {
		this.entityManager.close();
	}

	@Test
	public void testRemoveAll() throws Exception {
		this.entityManager.getTransaction().begin();
		int count = this.bean.removeAll();
		this.entityManager.getTransaction().commit();
		assertThat(count, equalTo(3));
	}

	private EmployeeEntity createEmployee(String name) {
		EmployeeEntity employee = new EmployeeEntity();
		employee.setName(name);
		return employee;
	}
}
