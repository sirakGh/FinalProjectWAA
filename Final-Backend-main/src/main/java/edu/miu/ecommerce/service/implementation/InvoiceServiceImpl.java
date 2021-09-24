package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Invoice;
import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.service.InvoiceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public Invoice generateInvoice(List<Order> orders) {
        return null;
    }
}
