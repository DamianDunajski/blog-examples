package pl.geeksoft.example.account.service;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.geeksoft.example.account.model.Account;
import pl.geeksoft.example.account.repository.AccountRepository;
import pl.geeksoft.example.account.repository.AccountRepositoryImpl;
import pl.geeksoft.example.account.service.exception.AccountAlreadyExistsException;
import pl.geeksoft.example.security.SecurityService;
import pl.geeksoft.example.security.SecurityServiceImpl;

/**
 * User: Damian Dunajski
 * Date: 25.05.2013
 * Time: 21:46
 */
@RunWith(Arquillian.class)
public class AccountServiceIntegrationTest {

	@EJB
	private AccountService accountService;

	@Deployment
	public static JavaArchive deploy() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClasses(AccountService.class, AccountServiceImpl.class)
				.addClasses(AccountRepository.class, AccountRepositoryImpl.class)
				.addClasses(SecurityService.class, SecurityServiceImpl.class)
				.addClass(AccountAlreadyExistsException.class)
				.addClass(Account.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
				.addPackages(true, "org/apache/commons")
				.addPackages(true, "org/joda/time");
	}

	@Test(expected = AccountAlreadyExistsException.class)
	public void registrationForDuplicatedEmailShouldFail() throws Exception {
		this.accountService.register("alice@example.com", "secret");
	}

	@Test
	public void testRegisterBob() throws Exception {
		Account account = this.accountService.register("bob@example.com", "secret");
		assertNotNull(account.getPassword());
		assertNotNull(account.getRegistrationDate());
	}

}
