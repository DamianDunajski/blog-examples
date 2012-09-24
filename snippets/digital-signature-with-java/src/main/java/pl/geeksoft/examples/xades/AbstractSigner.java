package pl.geeksoft.examples.xades;

import java.io.StringWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import pl.geeksoft.examples.util.DOMUtils;

public class AbstractSigner {

	protected Document createDocument() throws ParserConfigurationException {
		Document document = DOMUtils.newDocument();
		Element content = document.createElement("content");
		content.setTextContent("Hello World");
		document.appendChild(content);
		return document;
	}

	protected String toString(Document document) throws TransformerException {
		StringWriter stringWriter = new StringWriter();
		DOMUtils.transform(document, stringWriter);
		return stringWriter.toString();
	}

}
