package me.jovi.hellospring.repositoryies;

import me.jovi.hellospring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by joyce on 2017/6/28.
 */
public interface RoleRepo extends JpaRepository<Role, String> {

    @Query(value = "select a.id as id,a.description as description,a.role_name as role_name,'IN' as roleStatus " +
                   "from t_role a " +
                   "where exists (select b.role_id as id from t_user_role b where b.user_id = :userId and a.id = b.role_id) " +
                   "union all " +
                   "select a.id as id,a.description as description,a.role_name as role_name,'OUT' as roleStatus " +
                   "from t_role a " +
                   "where not exists (select b.role_id as id from t_user_role b where b.user_id = :userId and a.id = b.role_id) ", nativeQuery = true)
    List<Role> getRoleWithAuthStatus(@Param("userId") String userId);

}
