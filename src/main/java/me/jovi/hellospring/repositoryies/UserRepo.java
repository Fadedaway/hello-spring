package me.jovi.hellospring.repositoryies;

import me.jovi.hellospring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by joyce on 2017/3/18.
 */
public interface UserRepo extends JpaRepository<User, Serializable> {
}
