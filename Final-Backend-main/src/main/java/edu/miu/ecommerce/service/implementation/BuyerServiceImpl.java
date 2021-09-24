package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.*;
import edu.miu.ecommerce.model.OrderAddressRequest;
import edu.miu.ecommerce.repository.*;
import edu.miu.ecommerce.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerDAO buyerDAO;

    @Autowired
    ReviewDAO reviewDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    ShoppingCartDAO shoppingCartDAO;

    @Autowired
    InvoiceDAO invoiceDAO;

    @Override
    public Buyer findBuyerById(long id) {
        return buyerDAO.findById(id).orElseThrow();
    }


    @Override
    public Buyer addBuyer(Buyer buyer) {
        Buyer savedBuyer = buyerDAO.save(buyer);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setBuyer(savedBuyer);
        shoppingCartDAO.save(shoppingCart);
        return savedBuyer;
    }

    @Override
    public List<Order> findBuyerOrdersById(long id) {
        Buyer buyer = findBuyerById(id);
        return orderDAO.findAllByBuyer(buyer);
    }

    @Override
    public Review addReviewByBuyerId(Review review, long id, long productId) {
        Buyer buyer = findBuyerById(id);
        Product product = productDAO.findById(productId).get();
        review.setBuyer(buyer);
        review.setProduct(product);
        review.setApproved(false);
        return reviewDAO.save(review);
    }

    @Override
    public List<Review> findReviewsByBuyerId(long id) {
        Buyer buyer = findBuyerById(id);
        return reviewDAO.findAllByBuyer(buyer);
    }

    @Override
    public Address addAddressToBuyer(Address address, long id) {
        Buyer buyer = findBuyerById(id);
        address.setBuyer(buyer);
        return addressDAO.save(address);
    }

    @Override
    public List<Address> getAddressesOfBuyer(long id) {
        Buyer buyer = findBuyerById(id);
        return addressDAO.findAllByBuyer(buyer);
    }

    @Override
    public List<Product> findOrCreateShoppingCart(long id) {
        Buyer buyer = findBuyerById(id);
        ShoppingCart shoppingCart = shoppingCartDAO.findFirstByBuyer(buyer);
        return shoppingCart.getProducts();
    }

    @Override
    public List<Product> addProductsToCart(List<Product> products, long id) {
        Buyer buyer = findBuyerById(id);
        ShoppingCart shoppingCart = shoppingCartDAO.findShoppingCartByBuyer(buyer);
        shoppingCart.setProducts(products);
        return shoppingCartDAO.save(shoppingCart).getProducts();
    }

    @Override
    public List<Product> clearShoppingCart(long id) {
        Buyer buyer = findBuyerById(id);
        ShoppingCart shoppingCart = shoppingCartDAO.findShoppingCartByBuyer(buyer);
        shoppingCart.setProducts(new ArrayList<>());
        return shoppingCartDAO.save(shoppingCart).getProducts();
    }

    @Override
    public Invoice processShoppingCart(OrderAddressRequest orderAddresses, long id) {
        List<Product> products = findOrCreateShoppingCart(id);
        if(products.size() > 0){
            Buyer buyer = findBuyerById(id);
            float totalPrice = products.stream().map(product -> product.getPrice()).reduce((price, total)-> price + total).get();
            System.out.println("Price Total: "+ totalPrice);
            List<Order> orders = products.stream().map(product -> {
                Order order = new Order();
                order.setStatus(OrderStatus.ORDERED);
                order.setBuyer(buyer);
                order.setProduct(product);
                order.setShippingAddress(orderAddresses.getShippingAddress());
                order.setBillingAddress(orderAddresses.getBillingAddress());
                return order;
            }).collect(Collectors.toList());
            List<Order> savedOrders = StreamSupport.stream(orderDAO.saveAll(orders).spliterator(), false).collect(Collectors.toList());
            buyer.setBalance(buyer.getBalance() - totalPrice);
            buyerDAO.save(buyer);
            Invoice invoice = new Invoice();
            invoice.setOrders(savedOrders);
            clearShoppingCart(id);
            return invoiceDAO.save(invoice);
        }
        return null;
    }
}
