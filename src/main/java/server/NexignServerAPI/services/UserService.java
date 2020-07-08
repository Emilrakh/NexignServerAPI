package server.NexignServerAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.NexignServerAPI.exception.ResourceNotFoundException;
import server.NexignServerAPI.entities.UserEntity;
import server.NexignServerAPI.models.UserModel;
import server.NexignServerAPI.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity addUser(UserModel userModel) {
        String name = userModel.getName();
        String email = userModel.getEmail();
        return this.userRepository.save(new UserEntity(name, email));
    }

    public UserModel getUserById(long userID)
        throws ResourceNotFoundException {
            UserEntity userEntity = userRepository.findById(userID)
                    .orElseThrow(()-> new ResourceNotFoundException("Not user with this ID " + userID));
        userEntity.setUserID(userID);
        Long id = userEntity.getUserID();
        String name = userEntity.getName();
        String email = userEntity.getEmail();
        String status = userEntity.getStatus();
        String oldStatus = userEntity.getOldStatus();
        Date actionDate = userEntity.getActionDate();
        UserModel userModel = new UserModel(id, name, email, status, actionDate, oldStatus);
        return userModel;
    }

//    @Override
//    public List<UserEntity> findByID(Iterable<Long> userID) {
//        return userRepository.findByID(userID);
//    }

//    @Override
//    public UserEntity findByID( Long userID){
//        return userRepository.findByID(userID);
//    }

//    public UserModel addNewStatusByID(long userID, String status) throws ResourceNotFoundException {
//        UserEntity userEntity = userRepository.findById(userID)
//                .orElseThrow(()-> new ResourceNotFoundException("Not user with this ID " + userID));
//        Long id = userEntity.getUserID();
//        String name = userEntity.getName();
//        String email = userEntity.getEmail();
//        Date actionDate = new Date();
//        String oldStatus = userEntity.getStatus();
//        String newStatus = userEntity.setStatus(status);
//        UserEntity newUser = userRepository.save(new UserEntity(id, name, email, newStatus, actionDate, oldStatus));
//        UserModel userModel = new UserModel(id, name, email, newStatus, actionDate, oldStatus);
//        return userModel;
//    }

    public UserEntity addNewStatusByID(Long userID, UserEntity userDetails )
            throws ResourceNotFoundException {
        UserEntity userEntity = userRepository.findById(userID)
                .orElseThrow(() -> new ResourceNotFoundException("Not user with this ID " + userID));
        userEntity.setOldStatus(userEntity.getStatus());
        userEntity.setStatus(userDetails.getStatus());
        userEntity.setActionDate(new Date());
        final UserEntity newUser = userRepository.save(userEntity);
        return newUser;
    }

    @Override
    public List<UserEntity> findByStatus(String status){
        return userRepository.findByStatus(status);
    }

    @Override
    public List<UserEntity> findByStatusAndActionDate(String status, Date actionDate) {
        return userRepository.findByStatusAndActionDate(status, actionDate);
    }
}
