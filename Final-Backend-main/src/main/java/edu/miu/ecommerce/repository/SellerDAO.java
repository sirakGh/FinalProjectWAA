package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerDAO extends CrudRepository<Seller, Long> {
}
