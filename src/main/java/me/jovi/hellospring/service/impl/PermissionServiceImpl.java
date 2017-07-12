package me.jovi.hellospring.service.impl;

import me.jovi.hellospring.entity.Permission;
import me.jovi.hellospring.entity.RolePermission;
import me.jovi.hellospring.repositoryies.PermissionRepo;
import me.jovi.hellospring.repositoryies.RolePermissionRepo;
import me.jovi.hellospring.service.PermissionService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by joyce on 2017/6/29.
 */
@Service(value = "permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager entityManager;

    @Autowired
    private PermissionRepo permissionRepo;

    @Autowired
    private RolePermissionRepo rolePermissionRepo;

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

    @Override
    public List<Permission> getPermissionWithAuthStatus(String roleId) {
        List<Permission> permissions = new ArrayList<Permission>();

        StringBuilder sql = new StringBuilder("select a.id as id,a.description as description,a.permission_name as permissionName,'IN' as permissionStatus ");
        sql.append("from t_permission a ");
        sql.append("where exists (select b.permission_id as id from t_role_permission b where b.role_id = :roleId and a.id = b.permission_id) ");
        sql.append("union all ");
        sql.append("select a.id as id,a.description as description,a.permission_name as permissionName,'OUT' as permissionStatus ");
        sql.append("from t_permission a ");
        sql.append("where not exists (select b.permission_id as id from t_role_permission b where b.role_id = :roleId and a.id = b.permission_id) ");

        Query query = entityManager.createNativeQuery(sql.toString()).setParameter("roleId", roleId);

        List result = query.getResultList();
        if (result!=null) {
            Iterator iterator = result.iterator();

            while (iterator.hasNext()){
                Object[] objects = (Object[]) iterator.next();
                Permission permission = new Permission();

                permission.setId(String.valueOf(objects[0]));
                permission.setDescription(String.valueOf(objects[1]));
                permission.setPermissionName(String.valueOf(objects[2]));
                permission.setPermissionStatus(String.valueOf(objects[3]));

                permissions.add(permission);
            }
        }

        return permissions;
    }

    @Override
    public void authPermission(String roleId, String ids) {
        if (StringUtils.isBlank(roleId)) {
            LOGGER.error("角色id没有传入，授权失败！");
            throw new RuntimeException("角色id没有传入，授权失败！");
        }

        List<RolePermission> rolePermissions = rolePermissionRepo.getRolePermissionList(roleId);

        //先删
        if (null != rolePermissions && rolePermissions.size() > 0){
            for (RolePermission rolePermission : rolePermissions){
                rolePermissionRepo.delete(rolePermission);
            }
        }

        String[] idArray = ids.split(",");

        //后插
        for (String id : idArray){
            if (StringUtils.isNotBlank(id)){
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(roleId);
                rolePermission.setPermissionId(id);

                rolePermissionRepo.save(rolePermission);
            }
        }
    }
}
