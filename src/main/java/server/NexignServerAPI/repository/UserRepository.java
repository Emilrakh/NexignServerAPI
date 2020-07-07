package server.NexignServerAPI.repository;

import org.springframework.stereotype.Repository;
import server.NexignServerAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}