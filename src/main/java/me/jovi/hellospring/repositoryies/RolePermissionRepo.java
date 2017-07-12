package me.jovi.hellospring.repositoryies;

import me.jovi.hellospring.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by joyce on 2017/7/12.
 */
public interface RolePermissionRepo extends JpaRepository<RolePermission, String> {

    @Query("select rolePermission from RolePermission rolePermission where rolePermission.roleId = :roleId")
    List<RolePermission> getRolePermissionList(@Param("roleId") String roleId);
}
