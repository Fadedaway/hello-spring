package me.jovi.hellospring.service.impl;

import me.jovi.hellospring.entity.Permission;
import me.jovi.hellospring.repositoryies.PermissionRepo;
import me.jovi.hellospring.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by joyce on 2017/6/29.
 */
@Service(value = "permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepo permissionRepo;

    @Override
    public List<Permission> getPermissionList() {
        return null;
    }
}
