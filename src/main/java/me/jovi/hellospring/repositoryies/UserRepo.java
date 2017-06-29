package me.jovi.hellospring.repositoryies;

import me.jovi.hellospring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by joyce on 2017/3/18.
 */
public interface UserRepo extends JpaRepository<User, String> {
}
