package pl.geeksoft.example.document.repository;

import javax.ejb.Stateless;

import pl.geeksoft.example.document.model.Invoice;

/**
 * User: Damian Dunajski
 * Date: 26.05.2013
 * Time: 19:16
 */
@Stateless
public class DocumentRepositoryImpl implements DocumentRepository {

	@Override
	public Invoice getInvoice(Long invoiceID) {
		return new Invoice();
	}

}
