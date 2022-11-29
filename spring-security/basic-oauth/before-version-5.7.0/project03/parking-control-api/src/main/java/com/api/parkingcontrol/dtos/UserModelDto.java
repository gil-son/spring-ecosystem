package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.RoleModel;
import com.api.parkingcontrol.models.UserModel;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserModelDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID userId;
    @NotBlank(message = "Required field")
    private String username;

    @NotBlank(message = "Required field")
    private String password;

    private List<RoleModelDto> roles = new ArrayList<>();

    public UserModelDto(UUID userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public UserModelDto() {}

    public UserModelDto(UserModel entity) {
        userId = entity.getUserId();
        username = entity.getUsername();
        entity.getRoles().forEach(role -> this.roles.add(new RoleModelDto(role)));
    }


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {return username;}

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {return password;}

    public List<RoleModelDto> getRoles() {return roles;}
}
