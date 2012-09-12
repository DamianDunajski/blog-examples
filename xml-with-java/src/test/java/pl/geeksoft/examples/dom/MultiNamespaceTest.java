package pl.geeksoft.examples.dom;


import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class MultiNamespaceTest {

	@Test
	public void test() throws Exception {
		String expectedXml = Resources.toString(getClass().getResource("/xades-fragment.xml"), Charsets.UTF_8);
		assertXMLEqual(expectedXml, DOMUtils.transform(buildDocument()));
	}

	private Document buildDocument() throws ParserConfigurationException {
		Document document = DOMUtils.newDocument();
		// signature
		Element signature = document.createElementNS("http://www.w3.org/2000/09/xmldsig#", "ds:Signature");
		signature.setAttribute("Id", "#xmldsig-282b2392");
		document.appendChild(signature);
		// qualifying properties
		Element qualifyingProperties = document.createElementNS("http://uri.etsi.org/01903/v1.3.2#", "xades:QualifyingProperties");
		qualifyingProperties.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:xades141", "http://uri.etsi.org/01903/v1.4.1#");
		qualifyingProperties.setAttribute("Target", "#xmldsig-282b2392");
		signature.appendChild(qualifyingProperties);
		// signed properties
		Element signedProperties = document.createElement("xades:SignedProperties");
		signedProperties.setAttribute("Id", "#xmldsig-282b2392-properties");
		qualifyingProperties.appendChild(signedProperties);
		// signed signature properties
		Element signedSignatureProperties = document.createElement("xades:SignedSignatureProperties");
		signedProperties.appendChild(signedSignatureProperties);
		// signing time
		Element signingTime = document.createElement("xades:SigningTime");
		signingTime.setTextContent("2012-09-12T15:45:07.901+01:00");
		signedSignatureProperties.appendChild(signingTime);
		// signing certificate
		Element signingCertificate = document.createElement("xades:SigningCertificate");
		signedSignatureProperties.appendChild(signingCertificate);
		// cert
		Element cert = document.createElement("xades:Cert");
		signingCertificate.appendChild(cert);
		// cert digest
		Element certDigest = document.createElement("xades:CertDigest");
		cert.appendChild(certDigest);
		// DigestMethod
		Element digestMethod = document.createElement("ds:DigestMethod");
		digestMethod.setAttribute("Algorithm", "http://www.w3.org/2000/09/xmldsig#sha1");
		certDigest.appendChild(digestMethod);
		// digest value
		Element digestValue = document.createElement("ds:DigestValue");
		digestValue.setTextContent("CbLyQLmlowrl=");
		certDigest.appendChild(digestValue);
		// issuer serial
		Element issuerSerial = document.createElement("xades:IssuerSerial");
		cert.appendChild(issuerSerial);
		// X509 issuer name
		Element x509IssuerName = document.createElement("ds:X509IssuerName");
		x509IssuerName.setTextContent("CN=developer, O=Ministerstwo Finansów, C=PL");
		issuerSerial.appendChild(x509IssuerName);
		// X509 serial number
		Element x509SerialNumber = document.createElement("ds:X509SerialNumber");
		x509SerialNumber.setTextContent("1677");
		issuerSerial.appendChild(x509SerialNumber);
		// signed data object properties
		Element signedDataObjectProperties = document.createElement("xades:SignedDataObjectProperties");
		signedProperties.appendChild(signedDataObjectProperties);
		// data object format
		Element dataObjectFormat = document.createElement("xades:DataObjectFormat");
		dataObjectFormat.setAttribute("ObjectReference", "#xmldsig-282b2392-object");
		signedDataObjectProperties.appendChild(dataObjectFormat);
		// mime type
		Element mimeType = document.createElement("xades:MimeType");
		mimeType.setTextContent("text/xml");
		dataObjectFormat.appendChild(mimeType);
		return document;
	}

}
