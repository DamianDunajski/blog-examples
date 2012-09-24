package pl.geeksoft.examples.xades;


import java.security.Key;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.signature.XMLSignature;
import org.w3c.dom.Document;

import xades4j.UnsupportedAlgorithmException;
import xades4j.algorithms.Algorithm;
import xades4j.algorithms.GenericAlgorithm;
import xades4j.production.EnvelopedXmlObject;
import xades4j.production.SignedDataObjects;
import xades4j.production.XadesBesSigningProfile;
import xades4j.production.XadesSigner;
import xades4j.properties.DataObjectDesc;
import xades4j.properties.DataObjectFormatProperty;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.impl.DefaultAlgorithmsProviderEx;
import xades4j.providers.impl.DirectKeyingDataProvider;

public class Xades4jSigner extends AbstractSigner {

	public String sign(Certificate certificate, Key key) throws Exception {
		KeyingDataProvider provider = new DirectKeyingDataProvider((X509Certificate) certificate, (PrivateKey) key);
		XadesSigner signer = new XadesBesSigningProfile(provider).withAlgorithmsProviderEx(new MyAlgorithmsProviderEx()).newSigner();
		// create document
		Document document = createDocument();
		// create object
		DataObjectDesc obj = new EnvelopedXmlObject(document.getDocumentElement(), "text/xml", null);
		obj.withDataObjectFormat(new DataObjectFormatProperty("text/xml"));
		// sign
		signer.sign(new SignedDataObjects(obj), document);
		return toString(document);
	}

	private class MyAlgorithmsProviderEx extends DefaultAlgorithmsProviderEx {

		@Override
		public Algorithm getSignatureAlgorithm(String keyAlgorithmName) throws UnsupportedAlgorithmException {
			if ("RSA".equals(keyAlgorithmName)) {
				return new GenericAlgorithm(XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA1);
			}
			return super.getSignatureAlgorithm(keyAlgorithmName);
		}

		@Override
		public String getDigestAlgorithmForDataObjsReferences() {
			return MessageDigestAlgorithm.ALGO_ID_DIGEST_SHA1;
		}

		@Override
		public String getDigestAlgorithmForReferenceProperties() {
			return MessageDigestAlgorithm.ALGO_ID_DIGEST_SHA1;
		}

	}

}
