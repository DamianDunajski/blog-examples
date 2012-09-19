package pl.geeksoft.examples.xades;

import java.io.StringReader;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;

import pl.geeksoft.examples.util.DOMUtils;

public class JdkSignerTest {

	@Test
	public void testSign() throws Exception {
		// sign
		String signXml = new JdkSigner().sign();
		// schema verify
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new URL("http://uri.etsi.org/01903/v1.4.1/XAdESv141.xsd"));
		schema.newValidator().validate(new DOMSource(DOMUtils.parseDocument(new StringReader(signXml))));
	}

}
