package com.example.springbootsecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "app_user", schema = "SpringSecurity",
        uniqueConstraints = @UniqueConstraint(name = "APP_USER_UK", columnNames = "user_name"))
public class AppUser {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "encryted_password", nullable = false)
    private String encrytedPassword;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "user_fullname")
    private String fullName;

    public AppUser() {
    }

    public AppUser(String userName, String encrytedPassword, boolean enabled, String fullName) {
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        this.enabled = enabled;
        this.fullName = fullName;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
