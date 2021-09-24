package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Role;

public interface RoleService {

    Iterable<Role> getAllRoles();

    Role getRoleByName(String name);

}
