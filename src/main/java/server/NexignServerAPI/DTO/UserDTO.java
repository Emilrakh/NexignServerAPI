package server.NexignServerAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.NexignServerAPI.models.UserModel;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserDTO {

    private long userID;
    private String name;
    private String email;
    private String status;
    private Date actionDate = new Date();
    private String oldStatus;

    public UserDTO() {}

    public UserDTO(UserModel userModel) {}

    public UserDTO(Long userID, String name, String email) {
        super();
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    public UserDTO(Long userID, String name, String email, String status) {
        super();
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public UserDTO(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public UserDTO(Long userID, String name, String email, String status, String oldStatus) {
        super();
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.status = status;
        this.oldStatus = oldStatus;
    }
}
