package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDAO extends CrudRepository<Admin, Long> {
}
