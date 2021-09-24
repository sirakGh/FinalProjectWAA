package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Invoice;
import edu.miu.ecommerce.domain.Order;

import java.util.List;


public interface InvoiceService {

    Invoice generateInvoice(List<Order> orders);
}
