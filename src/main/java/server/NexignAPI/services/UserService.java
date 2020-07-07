package server.NexignAPI.services;


import org.springframework.stereotype.Service;
import server.NexignServerAPI.exception.ResourceNotFoundException;
import server.NexignServerAPI.model.User;
import server.NexignServerAPI.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public long addUser(String name, String email) {
        if (userRepository.existsByName(name) && userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("This user already exist");
        }
        return this.userRepository.save(new User(name, email)).getUserID();
    }

    public User getUserById(long userID)
        throws ResourceNotFoundException {
            User user = userRepository.findById(userID)
                    .orElseThrow(()-> new ResourceNotFoundException("Not user with this ID " + userID));
        return user;
    }

    public User addNewStatusByID(long userID, User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userID)
                .orElseThrow(()-> new ResourceNotFoundException("Not user with this ID " + userID));
        user.setStatus(userDetails.getStatus());
        user.setActionDate(userDetails.getActionDate());

        return user;
    }

}
