package me.jovi.hellospring.service.impl;

import me.jovi.hellospring.entity.Role;
import me.jovi.hellospring.entity.UserRole;
import me.jovi.hellospring.repositoryies.RoleRepo;
import me.jovi.hellospring.repositoryies.UserRoleRepo;
import me.jovi.hellospring.service.RoleService;
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
 * Created by joyce on 2017/6/28.
 */
@Service(value = "roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager entityManager;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Override
    public List<Role> getRoleList() {
        return roleRepo.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleRepo.save(role);
    }

    @Override
    public void deleteRoleById(String id) {
        Role role = roleRepo.findOne(id);

        if (null != role)
            roleRepo.delete(role);
    }

    @Override
    public void editRole(Role role) {
        Role oldRole = roleRepo.findOne(role.getId());

        oldRole.setDescription(role.getDescription());
        oldRole.setRoleName(role.getRoleName());

        roleRepo.saveAndFlush(oldRole);
    }

    @Override
    public Role getRoleById(String id) {
        return roleRepo.findOne(id);
    }

    @Override
    public List<Role> getRoleWithAuthStatus(String userId) {
        List<Role> roles = new ArrayList<Role>();

        StringBuilder sql = new StringBuilder("select a.id as id,a.description as description,a.role_name as roleName,'IN' as roleStatus ");
        sql.append("from t_role a ");
        sql.append("where exists (select b.role_id as id from t_user_role b where b.user_id = :userId and a.id = b.role_id) ");
        sql.append("union all ");
        sql.append("select a.id as id,a.description as description,a.role_name as roleName,'OUT' as roleStatus ");
        sql.append("from t_role a ");
        sql.append("where not exists (select b.role_id as id from t_user_role b where b.user_id = :userId and a.id = b.role_id) ");

        Query query = entityManager.createNativeQuery(sql.toString()).setParameter("userId", userId);

        List result = query.getResultList();
        if (result!=null) {
            Iterator iterator = result.iterator();

            while (iterator.hasNext()){
                Object[] objects = (Object[]) iterator.next();
                Role role = new Role();

                role.setId(String.valueOf(objects[0]));
                role.setDescription(String.valueOf(objects[1]));
                role.setRoleName(String.valueOf(objects[2]));
                role.setRoleStatus(String.valueOf(objects[3]));

                roles.add(role);
            }
        }

        return roles;
    }

    @Override
    public void authRole(String ids, String userId) {
        if (StringUtils.isBlank(userId)) {
            LOGGER.error("用户id没有传入，授权失败！");
            throw new RuntimeException("用户id没有传入，授权失败！");
        }

        List<UserRole> userRoleList = userRoleRepo.getUserRoleList(userId);

        //先删
        if (null != userRoleList && userRoleList.size() > 0){
            for (UserRole userRole : userRoleList){
                userRoleRepo.delete(userRole);
            }
        }

        String[] idArray = ids.split(",");

        //后插
        for (String id : idArray){
            if (StringUtils.isNotBlank(id)){
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(id);

                userRoleRepo.save(userRole);
            }
        }
    }
}
