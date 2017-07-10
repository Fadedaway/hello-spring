package me.jovi.hellospring.entity.vo;

import me.jovi.hellospring.entity.Role;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by joyce on 2017/7/10.
 */
@Entity
public class RoleVO extends Role {

    @Column(name = "role_status")
    private String roleStatus;

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }
}
