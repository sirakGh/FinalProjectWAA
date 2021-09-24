package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Review;
import edu.miu.ecommerce.model.ProductRequest;
import edu.miu.ecommerce.repository.OrderDAO;
import edu.miu.ecommerce.repository.ProductDAO;
import edu.miu.ecommerce.repository.ReviewDAO;
import edu.miu.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    ReviewDAO reviewDAO;

    @Override
    public List<Product> getAllProducts() {
        return StreamSupport.stream(productDAO.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Product getProductById(long id) {
        return productDAO.findById(id).orElseThrow();
    }
    @Override
    public void deleteProduct(long id) {
        Product product = getProductById(id);
        Order order = orderDAO.findFirstByProduct(product);
//        TODO add check if product has reviews
        if(order == null){
            productDAO.deleteById(id);
        }
    }

    @Override
    public Product updateProduct(ProductRequest productRequest, long id) {
        Product product = getProductById(id);
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());

        return productDAO.save(product);
    }

    @Override
    public List<Review> getReviewsOfProduct(long id) {
        Product product = getProductById(id);
        return reviewDAO.findAllByProduct(product);
    }

    @Override
    public List<Order> getOrdersOfProduct(long id) {
        Product product = getProductById(id);
        return orderDAO.findAllByProduct(product);
    }
}
