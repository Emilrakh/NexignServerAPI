package server.NexignServerAPI.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    public User() {
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

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setActionDate(java.util.Date actionDate) {
        this.actionDate = actionDate;
    }

    public long getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public java.util.Date getActionDate() {
        return actionDate;
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
