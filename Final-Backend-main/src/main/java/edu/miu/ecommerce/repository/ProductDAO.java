package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Seller;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProductDAO extends CrudRepository<Product, Long> {

    Set<Product> findAllBySeller(Seller seller);
 }
