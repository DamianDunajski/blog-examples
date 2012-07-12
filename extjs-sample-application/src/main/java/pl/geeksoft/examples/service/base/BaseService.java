package pl.geeksoft.examples.service.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseService {

	@PersistenceContext(unitName = "master")
	protected EntityManager entityManager;

}
