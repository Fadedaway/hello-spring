package me.jovi.hellospring.entity;

import javax.persistence.*;

/**
 * Created by joyce on 2017/6/23.
 */
@Entity
@Table(name = "t_role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "permission_id")
    private int permissionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }
}
