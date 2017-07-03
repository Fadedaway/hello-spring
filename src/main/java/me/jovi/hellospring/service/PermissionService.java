package me.jovi.hellospring.service;

import me.jovi.hellospring.entity.Permission;

import java.util.List;

/**
 * Created by joyce on 2017/6/29.
 */
public interface PermissionService {

    List<Permission> getPermissionList();
}
