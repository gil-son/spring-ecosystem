package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.RoleModel;
import com.api.parkingcontrol.models.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


public class RoleModelDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public RoleModelDto(){}

    public RoleModelDto(RoleModel entity){
        roleId = entity.getRoleId();
        roleName = entity.getRoleName();
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }


}
