package pl.geeksoft.example.document.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.geeksoft.example.document.model.Invoice;
import pl.geeksoft.example.document.repository.DocumentRepository;

/**
 * User: Damian Dunajski
 * Date: 26.05.2013
 * Time: 19:11
 */
@Stateless
public class InvoiceServiceImpl implements InvoiceService {

	@EJB
	private DocumentRepository documentRepository;

	@Override
	public byte[] print(Long invoiceID) {
		Invoice invoice = documentRepository.getInvoice(invoiceID);
		return invoice.toString().getBytes();
	}

}
