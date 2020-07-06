package server.NexignServerAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.NexignServerAPI.exception.ResourceNotFoundException;
import server.NexignServerAPI.model.User;
import server.NexignServerAPI.repository.UserRepository;


import java.util.List;

@RestController
@RequestMapping("api/first/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("addUser")
    public User addUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity<User> getUserByID(@PathVariable(value = "userID") Long userID)
        throws ResourceNotFoundException {
            User user = userRepository.findById(userID).orElseThrow(()-> new ResourceNotFoundException("Not user with this ID " + userID));
                return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users/{userID}")
    public ResponseEntity<User> addNewStatusByID(@PathVariable(value = "userID") Long userID, @Validated @RequestBody User userDetails )
            throws ResourceNotFoundException {
        User user = userRepository.findById(userID).orElseThrow(()-> new ResourceNotFoundException("Not user with this ID " + userID));
        user.setStatus(userDetails.getStatus());
        user.setActionDate(userDetails.getActionDate());

        return ResponseEntity.ok(this.userRepository.save(user));
    }
}
