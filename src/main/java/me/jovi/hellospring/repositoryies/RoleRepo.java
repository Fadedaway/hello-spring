package me.jovi.hellospring.repositoryies;

import me.jovi.hellospring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by joyce on 2017/6/28.
 */
public interface RoleRepo extends JpaRepository<Role, String> {
}
