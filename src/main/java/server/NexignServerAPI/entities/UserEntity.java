package server.NexignServerAPI.entities;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    private String name;
    private String email;
    @Column(name = "status")
    private String status = "none";

    @Basic
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate = new Date();
    private String oldStatus = "none";

    public UserEntity(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public String setStatus(String status) {
        this.status = status;
        return status;
    }

    @Override
    public String toString() {
        return "Users{" +
                "ID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
