package pl.geeksoft.example.security;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * User: Damian Dunajski
 * Date: 26.05.2013
 * Time: 17:38
 */
public class SecurityServiceImplTest {

	private SecurityServiceImpl service;

	@Before
	public void init() {
		service = new SecurityServiceImpl();
	}

	@Test
	public void testEncrypt() throws Exception {
		assertEquals("2bb80d537b1da3e38bd30361aa855686bde0eacd7162fef6a25fe97bf527a25b", service.encrypt("secret"));
	}
}
