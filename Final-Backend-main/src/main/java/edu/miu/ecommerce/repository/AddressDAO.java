package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Address;
import edu.miu.ecommerce.domain.Buyer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressDAO extends CrudRepository<Address,Long> {

    List<Address> findAllByBuyer(Buyer buyer);
}
