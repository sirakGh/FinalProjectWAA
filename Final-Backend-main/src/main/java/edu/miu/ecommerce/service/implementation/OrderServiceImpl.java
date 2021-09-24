package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.OrderStatus;
import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.repository.OrderDAO;
import edu.miu.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    public Order findOrderById(long id){
        return orderDAO.findById(id).get();
    }

    @Override
    public Order cancelOrder(long orderId) {
        Order order = findOrderById(orderId);
        if(order.getStatus() == OrderStatus.ORDERED){
            order.setStatus(OrderStatus.CANCELLED);
        }
        return orderDAO.save(order);
    }

    @Override
    public Order shipOrder(long orderId) {
        Order order = findOrderById(orderId);
        if (order.getStatus() == OrderStatus.ORDERED){
            order.setStatus(OrderStatus.SHIPPED);
        }
        return orderDAO.save(order);
    }

    @Override
    public Order deliverOrder(long orderId) {
        Order order = findOrderById(orderId);
        if (order.getStatus() == OrderStatus.SHIPPED){
            order.setStatus(OrderStatus.DELIVERED);
        }
        return orderDAO.save(order);
    }
}
