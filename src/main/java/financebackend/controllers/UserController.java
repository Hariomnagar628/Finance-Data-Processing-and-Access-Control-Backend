package financebackend.controllers;

import financebackend.model.User;
import financebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public  User createUser(@RequestBody User user,@RequestHeader("role") String role)
    {
        if (!role.equals("ADMIN")) {
            throw new RuntimeException("Access Denied: Only ADMIN can create users");
        }

        return  userService.saveuser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

}
