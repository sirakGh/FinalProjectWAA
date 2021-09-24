package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.User;
import edu.miu.ecommerce.model.UserAvailabilityRequest;
import edu.miu.ecommerce.repository.UserDAO;
import edu.miu.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username).get();
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userDAO.findById(id).orElseThrow();
    }

    @Override
    public User addUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteById(id);

    }

    @Override
    public User isUsernameAvailable(UserAvailabilityRequest userAvailabilityRequest) {
        //TODO add api endpoint
        return userDAO.findByUsername(userAvailabilityRequest.getUsername()).get();
    }
}
