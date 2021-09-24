package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Buyer;
import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDAO extends CrudRepository<Order,Long> {

    List<Order> findAllByBuyer(Buyer buyer);

    Order findFirstByProduct(Product product);

    List<Order> findAllByProduct(Product product);
}
