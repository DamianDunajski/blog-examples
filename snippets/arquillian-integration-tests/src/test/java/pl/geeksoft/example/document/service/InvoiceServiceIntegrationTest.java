package pl.geeksoft.example.document.service;

import static org.junit.Assert.assertTrue;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.geeksoft.example.account.service.AccountService;
import pl.geeksoft.example.account.service.AccountServiceImpl;
import pl.geeksoft.example.document.repository.DocumentRepository;
import pl.geeksoft.example.document.repository.DocumentRepositoryImpl;

/**
 * User: Damian Dunajski
 * Date: 26.05.2013
 * Time: 19:33
 */
@RunWith(Arquillian.class)
public class InvoiceServiceIntegrationTest {

	@EJB
	private InvoiceService invoiceService;

	@Deployment
	public static JavaArchive deploy() {
		return ShrinkWrap.create(JavaArchive.class).addClasses(AccountService.class, AccountServiceImpl.class)
				.addClasses(InvoiceService.class, InvoiceServiceImpl.class)
				.addClasses(DocumentRepository.class, DocumentRepositoryImpl.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsManifestResource("META-INF/persistence.xml", "persistence.xml");
	}

	@Test
	public void printingShouldReturnNonEmptyByteArray() {
		assertTrue(invoiceService.print(1L).length > 0);
	}

}
