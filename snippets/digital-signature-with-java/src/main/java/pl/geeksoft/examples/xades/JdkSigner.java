package pl.geeksoft.examples.xades;

import java.security.Key;
import java.security.cert.Certificate;

import javax.xml.XMLConstants;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import pl.geeksoft.examples.util.DOMUtils;

import com.google.common.collect.Lists;

public class JdkSigner extends AbstractSigner {

	public String sign(Certificate certificate, Key key) throws Exception {
		String id = "xmldsig-1";
		XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
		// signed info
		CanonicalizationMethod canonicalizationMethod = signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null);
		SignatureMethod signatureMethod = signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null);
		DigestMethod digestMethod = signatureFactory.newDigestMethod(DigestMethod.SHA1, null);
		// references
		Reference documentReference = signatureFactory.newReference("#" + id + "-document", digestMethod, null, "http://www.w3.org/2000/09/xmldsig#Object", id + "-document-ref");
		Reference signedPropertiesReference = signatureFactory.newReference("#" + id + "-signed-properties", digestMethod, null, "http://uri.etsi.org/01903#SignedProperties", null);
		SignedInfo signedInfo = signatureFactory.newSignedInfo(canonicalizationMethod, signatureMethod, Lists.newArrayList(documentReference, signedPropertiesReference));
		// key info
		KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
		X509Data x509Data = keyInfoFactory.newX509Data(Lists.newArrayList(certificate));
		KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Lists.newArrayList(x509Data));
		// object
		Document document = createDocument();
		XMLObject documentXmlObject = signatureFactory.newXMLObject(Lists.newArrayList(new DOMStructure(document.getDocumentElement())), id + "-document", "text/xml", null);
		Document signedProperties = createSignedProperties(id);
		XMLObject signedPropertiesXmlObject = signatureFactory.newXMLObject(Lists.newArrayList(new DOMStructure(signedProperties.getDocumentElement())), null, null, null);
		// xml signature
		XMLSignature xmlSignature = signatureFactory.newXMLSignature(signedInfo, keyInfo, Lists.newArrayList(documentXmlObject, signedPropertiesXmlObject), id, null);
		DOMSignContext signContext = new DOMSignContext(key, document);
		signContext.putNamespacePrefix(XMLSignature.XMLNS, "ds");
		xmlSignature.sign(signContext);
		// return
		return toString(document);
	}

	private Document createSignedProperties(String target) throws ParserConfigurationException {
		Document document = DOMUtils.newDocument();
		// qualifying properties
		Element qualifyingProperties = document.createElementNS("http://uri.etsi.org/01903/v1.3.2#", "xades:QualifyingProperties");
		qualifyingProperties.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:xades141", "http://uri.etsi.org/01903/v1.4.1#");
		qualifyingProperties.setAttribute("Target", "#" + target);
		document.appendChild(qualifyingProperties);
		// signed properties
		Element signedProperties = document.createElement("xades:SignedProperties");
		signedProperties.setAttribute("Id", target + "-signed-properties");
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
		digestValue.setTextContent("aGVsbG8gd29ybGQ=");
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
		dataObjectFormat.setAttribute("ObjectReference", "#" + target + "-document-ref");
		signedDataObjectProperties.appendChild(dataObjectFormat);
		// mime type
		Element mimeType = document.createElement("xades:MimeType");
		mimeType.setTextContent("text/xml");
		dataObjectFormat.appendChild(mimeType);
		return document;
	}

}
