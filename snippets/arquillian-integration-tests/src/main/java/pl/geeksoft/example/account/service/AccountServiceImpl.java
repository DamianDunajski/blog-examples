package pl.geeksoft.example.account.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.joda.time.DateTime;

import pl.geeksoft.example.account.exception.AccountAlreadyExistsException;
import pl.geeksoft.example.account.model.Account;
import pl.geeksoft.example.security.SecurityService;

@Stateless
public class AccountServiceImpl implements AccountService {

	@EJB
	private AccountRepository accountRepository;
	@EJB
	private SecurityService   securityService;

	@Override
	public Account register(String email, String password) throws AccountAlreadyExistsException {
		checkExists(email);

		Account account = new Account();
		account.setEmail(email);
		account.setPassword(securityService.encrypt(password));
		account.setRegistrationDate(DateTime.now().toDate());

		accountRepository.save(account);
		return account;
	}

	private void checkExists(String email) throws AccountAlreadyExistsException {
		if ("alice@example.com".equals(email)) {
			throw new AccountAlreadyExistsException(email);
		}
	}

}
