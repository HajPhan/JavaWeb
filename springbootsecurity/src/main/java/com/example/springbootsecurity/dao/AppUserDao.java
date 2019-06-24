package com.example.springbootsecurity.dao;

import com.example.springbootsecurity.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * AppUserDao: sử dụng để thao tác với bảng APP_USER (phương thức tìm kiếm một người dùng trong database với tên đăng nhập)
 *
 */

@Repository
@Transactional
public class AppUserDao {
    @Autowired
    private EntityManager entityManager;

    public AppUser findUserAccount(String userName){
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " + " Where e.userName = :userName";
            Query query = entityManager.createQuery(sql,AppUser.class);
            query.setParameter("userName",userName);
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
