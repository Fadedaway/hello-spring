package me.jovi.hellospring.service;

import me.jovi.hellospring.entity.Role;

import java.util.List;

/**
 * Created by joyce on 2017/6/28.
 */
public interface RoleService {

    List<Role> getRoleList();

    void addRole(Role role);
}
