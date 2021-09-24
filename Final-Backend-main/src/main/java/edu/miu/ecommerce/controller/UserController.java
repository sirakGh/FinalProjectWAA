package edu.miu.ecommerce.controller;

import edu.miu.ecommerce.domain.User;
import edu.miu.ecommerce.model.UserAvailabilityRequest;
import edu.miu.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return  userService.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id){
          userService.deleteUser(id);
    }

    @GetMapping("/users/isUsernameAvailable")
    public User isUsernameAvailable(@RequestBody UserAvailabilityRequest userAvailabilityRequest){
        return userService.isUsernameAvailable(userAvailabilityRequest);
    }


}
