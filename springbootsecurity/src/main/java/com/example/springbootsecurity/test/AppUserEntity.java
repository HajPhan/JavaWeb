package com.example.springbootsecurity.test;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app_user", schema = "SpringSecurity", catalog = "")
public class AppUserEntity {
    private long userId;
    private String userName;
    private String encrytedPassword;
    private boolean enabled;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "encryted_password")
    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    @Basic
    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserEntity that = (AppUserEntity) o;
        return userId == that.userId &&
                enabled == that.enabled &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(encrytedPassword, that.encrytedPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, encrytedPassword, enabled);
    }
}
