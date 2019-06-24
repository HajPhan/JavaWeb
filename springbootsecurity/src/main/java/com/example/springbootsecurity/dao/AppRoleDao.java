package com.example.springbootsecurity.dao;

import com.example.springbootsecurity.model.AppUser;
import com.example.springbootsecurity.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AppRoleDao {
    private EntityManagerFactory emf;
    private EntityManager entityManager;

//    Trả về danh sách các Role ứng với từng

    public List<String> getRoleNames(int userId){
//        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " + " where ur.appUser.userId = :userId";
//        Query query = this.entityManager.createQuery(sql,String.class);
//        query.setParameter("userId",userId);
        this.entityManager = this.emf.createEntityManager();
        String sql = "Select ur from " + UserRole.class.getName() + " ur " //
                + " where ur.appRole.userId = :userId ";
//        String sql = "Select e from " + AppUser.class.getName() + " e " + " Where e.userName = :userName";
        Query query = this.entityManager.createQuery(sql);
        query.setParameter("userId", userId);

        return query.getResultList();
    }
}
