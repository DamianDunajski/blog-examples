package pl.geeksoft.examples.xades;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.security.KeyStore;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Before;
import org.xml.sax.SAXException;

import pl.geeksoft.examples.util.DOMUtils;

public class AbstractSignerTest {

	protected static final String KEYSTORE = "/keystore.jks";
	protected static final String ALIAS    = "selfsigned";

	protected static final String PASSWORD = "secret";

	protected KeyStore keyStore;

	@Before
	public void init() throws Exception {
		this.keyStore = KeyStore.getInstance("JKS");
		this.keyStore.load(getClass().getResourceAsStream(KEYSTORE), PASSWORD.toCharArray());
	}

	protected void verifySchema(String signXml) throws SAXException, IOException, ParserConfigurationException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new URL("http://uri.etsi.org/01903/v1.4.1/XAdESv141.xsd"));
		schema.newValidator().validate(new DOMSource(DOMUtils.parseDocument(new StringReader(signXml))));
	}

}
