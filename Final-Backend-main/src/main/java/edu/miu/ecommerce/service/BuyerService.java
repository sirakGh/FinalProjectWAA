package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.*;
import edu.miu.ecommerce.model.OrderAddressRequest;

import java.util.List;


public interface BuyerService {

    Buyer findBuyerById(long id);

    Buyer addBuyer(Buyer buyer);

    List<Order> findBuyerOrdersById(long id);

    Review addReviewByBuyerId(Review review, long id, long productId);

    List<Review> findReviewsByBuyerId(long id);

    Address addAddressToBuyer(Address address, long id);

    List<Address> getAddressesOfBuyer(long id);

    List<Product> findOrCreateShoppingCart(long id);

    List<Product> addProductsToCart(List<Product> products, long id);

    List<Product> clearShoppingCart(long id);

    Invoice processShoppingCart(OrderAddressRequest orderAddresses, long id);
}
