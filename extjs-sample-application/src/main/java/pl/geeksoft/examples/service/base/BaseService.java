package pl.geeksoft.examples.service.base;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {

	private static final Logger log = LoggerFactory.getLogger(BaseService.class);
	
	@PersistenceContext(unitName = "master")
	protected EntityManager entityManager;
	@Resource
	protected UserTransaction transaction;

	protected void beginTransaction() {
		try {
			this.transaction.begin();
		} catch (NotSupportedException ex) {
			log.error(ex.getMessage(), ex);
		} catch (SystemException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	protected void commitTransaction() {
		try {
			this.transaction.commit();
		} catch (RollbackException ex) {
			log.error(ex.getMessage(), ex);
		} catch (HeuristicMixedException ex) {
			log.error(ex.getMessage(), ex);
		} catch (HeuristicRollbackException ex) {
			log.error(ex.getMessage(), ex);
		} catch (SystemException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	protected void rollbackTransaction() {
		try {
			this.transaction.rollback();
		} catch (SystemException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

}
