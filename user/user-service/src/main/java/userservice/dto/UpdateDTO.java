package userservice.dto;

import lombok.Data;

@Data
public class UpdateDTO {
    private String username;
    private String password;
    private String newPassword;
}
