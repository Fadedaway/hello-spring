package me.jovi.hellospring.service.impl;

import me.jovi.hellospring.entity.Role;
import me.jovi.hellospring.repositoryies.RoleRepo;
import me.jovi.hellospring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by joyce on 2017/6/28.
 */
@Service(value = "roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager entityManager;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<Role> getRoleList() {
        return roleRepo.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleRepo.save(role);
    }
}
