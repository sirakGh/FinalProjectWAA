package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Role;
import edu.miu.ecommerce.repository.RoleDAO;
import edu.miu.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl  implements RoleService {

    @Autowired
    RoleDAO roleDAO;

    @Override
    public Iterable<Role> getAllRoles() {
        return roleDAO.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.findRoleByRole(name).get();
    }
}
