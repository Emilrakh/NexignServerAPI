package server.NexignServerAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private long userID;
    private String name;
    private String email;
    private String status = "none";
    private Date actionDate = new Date();
    private String oldStatus = "none";

    public UserModel(Long userID, String name, String email) {
        super();
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    public UserModel(Long userID, String name, String email, String status, String oldStatus) {
        super();
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.status = status;
        this.name = oldStatus;
    }

    public String setStatus(String status) {
        this.status = status;
        return status;
    }
}
