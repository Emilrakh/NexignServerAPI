package server.NexignServerAPI.services;

import server.NexignServerAPI.entities.UserEntity;
import server.NexignServerAPI.exception.ResourceNotFoundException;
import server.NexignServerAPI.models.UserModel;


import java.util.Date;
import java.util.List;

public interface IUserService{
    List<UserEntity> findByStatusAndActionDate(String status, Date actionDate);
    List<UserEntity> findByStatus(String status);
    List<UserEntity> getAllUsers();
    UserEntity addNewStatusByID(Long userID, UserEntity userDetails)throws ResourceNotFoundException;
    UserEntity addUser(UserModel userModel);
    UserModel getUserById(long userID) throws ResourceNotFoundException;
}
