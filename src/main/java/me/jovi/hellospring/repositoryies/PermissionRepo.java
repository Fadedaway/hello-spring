package me.jovi.hellospring.repositoryies;

import me.jovi.hellospring.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by joyce on 2017/6/29.
 */
public interface PermissionRepo extends JpaRepository<Permission, String> {
}
