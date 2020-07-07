package server.NexignServerAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import server.NexignAPI.services.UserService;
import server.NexignServerAPI.exception.ResourceNotFoundException;
import server.NexignServerAPI.model.User;

import java.util.List;

@RestController
@RequestMapping("api/first/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PutMapping("addUser")
    public long addUser(@RequestParam("username") String name, @RequestParam("email") String email) {
        return userService.addUser(name, email);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity<User> getUserByID(@PathVariable(value = "userID") Long userID)
        throws ResourceNotFoundException {
            User user = userService.getUserById(userID);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users/{userID}")
    public ResponseEntity<User> addNewStatusByID(@PathVariable(value = "userID") Long userID, @Validated @RequestBody User userDetails )
            throws ResourceNotFoundException {
        User user = userService.addNewStatusByID(userID, userDetails);
        user.setStatus(userDetails.getStatus());
        user.setActionDate(userDetails.getActionDate());

        return ResponseEntity.ok().body(user);
    }
}
