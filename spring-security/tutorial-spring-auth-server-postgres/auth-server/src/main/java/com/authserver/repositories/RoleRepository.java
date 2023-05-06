package com.authserver.repositories;

import com.authserver.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, String> {

    Optional<RoleModel> findByRoleId(String roleId);

}