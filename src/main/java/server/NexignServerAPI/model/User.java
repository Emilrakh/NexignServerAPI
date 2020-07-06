package server.NexignServerAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;

    private String name;

    private String email;

    private String status;
//    @Column(name = "actionDate")
//    private LocalDateTime actionDate;

    public User() {
        super();
    }

    public User(String name, String email) {
        super();
        this.name = name;
        this.email = email;
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

//    public void setActionDate(LocalDateTime actionDate) {
//        this.actionDate = actionDate;
//    }

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

//    public LocalDateTime getActionDate() {
//        return actionDate;
//    }

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
