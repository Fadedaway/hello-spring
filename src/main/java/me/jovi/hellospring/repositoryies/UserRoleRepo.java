package me.jovi.hellospring.repositoryies;

import me.jovi.hellospring.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by joyce on 2017/7/11.
 */
public interface UserRoleRepo extends JpaRepository<UserRole, String> {

    @Query(value = "select userRole from UserRole userRole where userRole.userId = :userId and userRole.roleId = :roleId ")
    UserRole getUserRole(@Param("roleId") String roleId,@Param("userId") String userId);

    @Query(value = "select userRole from UserRole userRole where userRole.userId = :userId")
    List<UserRole> getUserRoleList(@Param("userId") String userId);
}
