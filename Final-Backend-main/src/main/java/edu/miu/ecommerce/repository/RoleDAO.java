package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleDAO extends CrudRepository<Role, Long> {

    Optional<Role> findRoleByRole(String role);
}
