package pl.geeksoft.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

public class EmployeePersistenceBean {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<EmployeeEntity> findAll() {
		return new ArrayList<>();
	}

	public int removeAll() {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaUpdate<EmployeeEntity> update = builder.createCriteriaUpdate(EmployeeEntity.class);
		Root<EmployeeEntity> employee = update.from(EmployeeEntity.class);
		update.set(EmployeeEntity_.removeTime, new Date());
		update.where(builder.isNull(employee.get(EmployeeEntity_.removeTime)));
		return this.entityManager.createQuery(update).executeUpdate();
	}

}
