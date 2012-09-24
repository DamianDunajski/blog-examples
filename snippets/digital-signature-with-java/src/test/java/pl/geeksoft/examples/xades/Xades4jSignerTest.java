package pl.geeksoft.examples.xades;

import java.security.Key;
import java.security.cert.Certificate;

import org.junit.Test;

public class Xades4jSignerTest extends AbstractSignerTest {

	@Test
	public void testSign() throws Exception {
		Certificate certificate = this.keyStore.getCertificate(ALIAS);
		Key key = this.keyStore.getKey(ALIAS, PASSWORD.toCharArray());
		// test
		String sign = new Xades4jSigner().sign(certificate, key);
		System.out.println("sign = \n" + sign);
		verifySchema(sign);
	}

}
