package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Buyer;
import org.springframework.data.repository.CrudRepository;

public interface BuyerDAO extends CrudRepository<Buyer, Long> {
}
