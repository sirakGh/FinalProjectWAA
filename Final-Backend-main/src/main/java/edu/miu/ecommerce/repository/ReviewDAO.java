package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Buyer;
import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewDAO extends CrudRepository<Review, Long> {

    List<Review> findAllByBuyer(Buyer buyer);
    List<Review> findAll();
    List<Review> findAllByProduct(Product product);
}
