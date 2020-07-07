package server.NexignServerAPI.model;

import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    private String name;
    private String email;
    private String status;
    @Basic
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate = new Date();

    public User(User user) {
        super();
    }

    public User(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public User(String name, String email, String status) {
        super();
        this.name = name;
        this.email = email;
        this.status = status;
        this.actionDate = actionDate;
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
