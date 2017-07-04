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
        return permissionRepo.findAll();
    }

    @Override
    public void addPermission(Permission permission) {
        permissionRepo.save(permission);
    }

    @Override
    public void editPermission(Permission permission) {
        Permission permissionOld = permissionRepo.findOne(permission.getId());

        permissionOld.setDescription(permission.getDescription());
        permissionOld.setPermissionName(permission.getPermissionName());

        permissionRepo.saveAndFlush(permission);
    }

    @Override
    public Permission getPermissionById(String id) {
        return permissionRepo.findOne(id);
    }

    @Override
    public void deletePermissionById(String id) {
        Permission permission = permissionRepo.findOne(id);

        if (null != permission){
            permissionRepo.delete(permission);
        }
    }
}
