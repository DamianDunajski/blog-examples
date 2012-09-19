package pl.geeksoft.examples.util;


import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DOMUtils {

	public static Document newDocument() throws ParserConfigurationException {
		DocumentBuilder documentBuilder = documentBuilderFactory().newDocumentBuilder();
		return documentBuilder.newDocument();
	}

	public static Document parseDocument(Reader reader) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilder documentBuilder = documentBuilderFactory().newDocumentBuilder();
		return documentBuilder.parse(new InputSource(reader));
	}

	public static String transform(Document document) throws TransformerException {
		StringWriter writer = new StringWriter();
		transform(document, writer);
		return writer.toString();
	}

	public static void transform(Document document, Writer writer) throws TransformerException {
		Transformer transformer = transformerFactory().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(new DOMSource(document), new StreamResult(writer));
	}

	private static DocumentBuilderFactory documentBuilderFactory() {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		return documentBuilderFactory;
	}

	private static TransformerFactory transformerFactory() {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		transformerFactory.setAttribute("indent-number", 2);
		return transformerFactory;
	}

}
