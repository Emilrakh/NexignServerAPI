package server.NexignServerAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long userID;
    private String name;
    private String email;
    private String status = "none";
    private Date actionDate = new Date();
    private String oldStatus = "none";

    public UserDTO(Long userID, String name, String email, String status, String oldStatus) {
        super();
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.status = status;
        this.oldStatus = oldStatus;
    }
}
