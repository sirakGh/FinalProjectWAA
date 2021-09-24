package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceDAO extends CrudRepository<Invoice, Long> {
}
