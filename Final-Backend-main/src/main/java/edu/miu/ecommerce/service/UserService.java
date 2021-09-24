package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.User;
import edu.miu.ecommerce.model.UserAvailabilityRequest;


public interface UserService {

    User getUserByUsername(String username);

    Iterable<User> getAllUsers();

    User getUserById(long id);

    User addUser(User user);

    void deleteUser(long id);

    User isUsernameAvailable(UserAvailabilityRequest userAvailabilityRequest);

}
