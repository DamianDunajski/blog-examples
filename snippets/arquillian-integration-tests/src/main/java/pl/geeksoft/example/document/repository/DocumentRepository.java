package pl.geeksoft.example.document.repository;

import pl.geeksoft.example.document.model.Invoice;

/**
 * User: Damian Dunajski
 * Date: 26.05.2013
 * Time: 19:14
 */
public interface DocumentRepository {

	Invoice getInvoice(Long invoiceID);

}
