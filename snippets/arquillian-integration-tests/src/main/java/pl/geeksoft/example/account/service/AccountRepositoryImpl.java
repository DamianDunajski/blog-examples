package pl.geeksoft.example.account.service;

import javax.ejb.Stateless;

import pl.geeksoft.example.account.model.Account;

/**
 * User: Damian Dunajski
 * Date: 25.05.2013
 * Time: 21:34
 */
@Stateless
public class AccountRepositoryImpl implements AccountRepository {

	@Override
	public void save(Account account) {
		System.out.println("account = " + account);
	}

}
