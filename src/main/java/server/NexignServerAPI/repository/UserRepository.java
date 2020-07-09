package server.NexignServerAPI.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.NexignServerAPI.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

//    @Query(value = "FROM UserEntity WHERE status = :status AND actionDate::timestamp >= :actionDate::timestamp ORDER BY actionDate",
//            nativeQuery = true)
//    List<UserEntity> findByStatusAndActionDate(@Param("status") String status, @Param("actionDate") Date actionDate);

    List<UserEntity> findByStatusAndActionDate(String status, Date actionDate);

    List<UserEntity> findByStatus(String status);
}