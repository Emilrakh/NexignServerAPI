package server.NexignServerAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.NexignServerAPI.DTO.UserDTO;
import server.NexignServerAPI.models.UserModel;
import server.NexignServerAPI.services.UserService;
import server.NexignServerAPI.exception.ResourceNotFoundException;
import server.NexignServerAPI.entities.UserEntity;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/first/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("addUser")
    public UserEntity addUser(@RequestBody UserDTO userDTO) {
        Long id = userDTO.getUserID();
        String name = userDTO.getName();
        String email = userDTO.getEmail();
        UserModel userModel = new UserModel(id, name, email);
        return userService.addUser(userModel);
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable(value = "userID") Long userID)
        throws ResourceNotFoundException {
        UserModel userModel = this.userService.getUserById(userID);
        Long id = userModel.getUserID();
        String name = userModel.getName();
        String email = userModel.getEmail();
        String status = userModel.getStatus();
        String oldStatus = userModel.getOldStatus();
        UserDTO userDTO = new UserDTO(id, name, email, status, oldStatus);
        return ResponseEntity.ok().body(userDTO);
    }

    @PutMapping("/users/{userID}")
    public ResponseEntity<UserEntity> addNewStatusByID(@PathVariable(value = "userID") Long userID, @Validated @RequestBody UserEntity userDetails)
            throws ResourceNotFoundException {
        UserModel userModel = userService.getUserById(userID);
        userModel.setOldStatus(userDetails.getStatus());
        userModel.setStatus(userDetails.getStatus());
        userModel.setActionDate(userDetails.getActionDate());
        final UserEntity newUser = userService.addNewStatusByID(userID, userDetails);
        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping("/users/status/{status}")
    public List<UserEntity> findByStatus(@PathVariable(value = "status") String status) {
        return userService.findByStatus(status);
    }

<<<<<<< HEAD
    @PostMapping("/users/statusTime/{status}")
    public List<UserEntity> findByStatusAndActionDate(@PathVariable(value = "status") String status, Date actionDate) {
=======
    @GetMapping("/users/status/{status}/{actionDate}")
<<<<<<< HEAD
    public List<UserEntity> findByStatusAndActionDate(@PathVariable(value = "status") String status,@PathVariable(value = "actionDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date actionDate) {
=======
    public List<UserEntity> findByStatusAndActionDate(@PathVariable(value = "status") String status,@PathVariable(value = "actionDate") Date actionDate) {
>>>>>>> master
>>>>>>> master
        return userService.findByStatusAndActionDate(status, actionDate);
    }
}
