package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Product;


public interface OrderService {

    Order findOrderById(long id);

    Order cancelOrder(long orderId);

    Order shipOrder(long orderId);

    Order deliverOrder(long orderId);
}
