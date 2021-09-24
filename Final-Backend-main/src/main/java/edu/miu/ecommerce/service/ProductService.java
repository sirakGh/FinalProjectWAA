package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Review;
import edu.miu.ecommerce.model.ProductRequest;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    void deleteProduct(long id);

    Product updateProduct(ProductRequest product, long id);

    List<Review> getReviewsOfProduct(long id);

    List<Order> getOrdersOfProduct(long id);
}
