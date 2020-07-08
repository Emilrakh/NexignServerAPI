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

//    @GetMapping("/users/{userID}")
//    public List<UserEntity> findByID(Iterable<Long> userID) {
//        return userService.findByID(userID);
//    }

//    @GetMapping("/users/{userID}")
//    public UserEntity findByID(Long userID){
//        return userService.findByID(userID);
//    }

//    @PutMapping("/users/{userID}")
//    public ResponseEntity<UserDTO> addNewStatusByID(@RequestBody UserDTO userDTO, @PathVariable String userID)
//            throws ResourceNotFoundException {
//        Long id = userDTO.getUserID();
//        String name = userDTO.getName();
//        String email = userDTO.getEmail();
//        String newStatus = userDTO.getStatus();
//        String oldStatus = userDTO.getStatus();
//        Date actionDate = new Date();
//        UserModel userModel = this.userService.addNewStatusByID(id, newStatus);
//        userDTO = new UserDTO(id, name, email, userModel.getStatus(), actionDate, oldStatus);
//        return ResponseEntity.ok().body(userDTO);
//    }

    @PutMapping("/users/{userID}")
    public ResponseEntity<UserEntity> addNewStatusByID(@PathVariable(value = "userID") Long userID, @Validated @RequestBody UserEntity userDetails)
            throws ResourceNotFoundException {
        UserModel userModel = userService.getUserById(userID);
        userModel.setOldStatus(userDetails.getStatus());
        userModel.setStatus(userDetails.getStatus());
        userModel.setActionDate(new Date());
        final UserEntity newUser = userService.addNewStatusByID(userID, userDetails);
        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping("/users/status/{status}")
    public List<UserEntity> findByStatus(@PathVariable(value = "status") String status) {
        return userService.findByStatus(status);
    }

    @GetMapping("/users/status/{status}/{actionDate}")
    public List<UserEntity> findByStatusAndActionDate(@PathVariable(value = "status") String status,@PathVariable(value = "actionDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date actionDate) {
        return userService.findByStatusAndActionDate(status, actionDate);
    }
}
