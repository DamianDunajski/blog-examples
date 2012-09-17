package pl.geeksoft.examples.xades;

import org.junit.Test;

public class JdkSignerTest {

	@Test
	public void testSign() throws Exception {
		new JdkSigner().sign();
	}

}
