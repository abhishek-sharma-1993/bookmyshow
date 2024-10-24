package bookmyshow.controller;

import bookmyshow.entities.User;
import bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody String name,
                                           @RequestBody String email,
                                           @RequestBody String mobile) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setMobile(mobile);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam("id") int id) {
        User user = userRepository.findById(id);
        return ResponseEntity.ok(user);
    }
}
