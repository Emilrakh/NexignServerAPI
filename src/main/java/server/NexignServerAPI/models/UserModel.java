package server.NexignServerAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserModel {

    private long userID;
    private String name;
    private String email;
    private String status;
    private Date actionDate = new Date();
    private String oldStatus;

    public UserModel() { }

    public UserModel(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public UserModel(Long userID, String name, String email) {
        super();
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    public UserModel(Long userID, String name, String email, String status) {
        super();
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public UserModel(Long userID, String name, String email, String status, String oldStatus) {
        super();
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.status = status;
        this.oldStatus = oldStatus;
    }

    public String setStatus(String status) {
        this.status = status;
        return status;
    }
}
