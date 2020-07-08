package server.NexignServerAPI.services;

import server.NexignServerAPI.entities.UserEntity;


import java.util.Date;
import java.util.List;

public interface IUserService{
    List<UserEntity> findByStatusAndActionDate(String status, Date actionDate);
    List<UserEntity> findByStatus(String status);

//    List<UserEntity> findByID(Iterable<Long> userID);
//    public UserEntity findByID( Long userID);
}
