package pl.geeksoft.examples.xades;

import java.io.StringReader;
import java.net.URL;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Before;
import org.junit.Test;

import pl.geeksoft.examples.util.DOMUtils;

public class JdkSignerTest {

	private static final String KEYSTORE = "/keystore.jks";
	private static final String ALIAS    = "selfsigned";

	private static final String PASSWORD = "secret";

	private KeyStore keyStore;

	@Before
	public void init() throws Exception {
		this.keyStore = KeyStore.getInstance("JKS");
		this.keyStore.load(getClass().getResourceAsStream(KEYSTORE), PASSWORD.toCharArray());
	}

	@Test
	public void testSign() throws Exception {
		Certificate certificate = this.keyStore.getCertificate(ALIAS);
		Key key = this.keyStore.getKey(ALIAS, PASSWORD.toCharArray());
		// sign
		String signXml = new JdkSigner().sign(certificate, key);
		// schema verify
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new URL("http://uri.etsi.org/01903/v1.4.1/XAdESv141.xsd"));
		schema.newValidator().validate(new DOMSource(DOMUtils.parseDocument(new StringReader(signXml))));
	}

}
