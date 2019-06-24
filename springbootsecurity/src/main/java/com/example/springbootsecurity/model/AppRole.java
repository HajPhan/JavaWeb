package com.example.springbootsecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "app_role", schema = "SpringSecurity",
        uniqueConstraints = {@UniqueConstraint(name = "APP_ROLE_UK", columnNames = "role_name")})
public class AppRole {

    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "role_name", nullable = false)
    private String roleName;


    public AppRole() {
    }

    public AppRole(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
