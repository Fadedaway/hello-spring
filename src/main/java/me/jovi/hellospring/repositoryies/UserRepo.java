package me.jovi.hellospring.repositoryies;

import me.jovi.hellospring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by joyce on 2017/3/18.
 */
public interface UserRepo extends JpaRepository<User, String> {

    @Query("SELECT user FROM User user WHERE user.loginName = :loginName")
    User getUserByLoginName(@Param("loginName") String loginName);
}
