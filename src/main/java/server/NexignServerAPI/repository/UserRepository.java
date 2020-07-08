package server.NexignServerAPI.repository;


import org.springframework.stereotype.Repository;
import server.NexignServerAPI.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

//    @Query(value = "SELECT * FROM UserEntity " +
//            "WHERE status = :status ",
//            nativeQuery = true)
//    List<UserEntity> findUserByStatus(@Param("status") String status);
//
//    @Query(value = "SELECT u FROM UserEntity u" +
//            "WHERE u.status = :status " +
//            "AND u.actionDate >= :actionDate "+
//            "ORDER BY u.actionDate",
//            nativeQuery = true)
//    List<UserEntity> findByStatusAndActionDate(@Param("status") String status, @Param("actionDate") Date actionDate);

    List<UserEntity> findByStatus(String status);

    List<UserEntity> findByStatusAndActionDate(String status,Date actionDate);
}