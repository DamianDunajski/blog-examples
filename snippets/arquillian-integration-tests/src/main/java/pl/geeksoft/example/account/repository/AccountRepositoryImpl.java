package pl.geeksoft.example.account.repository;

import javax.ejb.Stateless;

import pl.geeksoft.example.account.model.Account;

/**
 * User: Damian Dunajski
 * Date: 25.05.2013
 * Time: 21:34
 */
@Stateless
public class AccountRepositoryImpl implements AccountRepository {

//	@PersistenceContext
//	private EntityManager entityManager;

	@Override
	public void save(Account account) {
//		if (account.getId() == null) {
//			entityManager.persist(account);
//		} else {
//			entityManager.merge(account);
//		}
	}

}
