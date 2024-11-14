package com.example.assignment.service.impl;

import com.example.assignment.HibernateUtil;
import com.example.assignment.service.UserService;
import jakarta.persistence.EntityManager;
import com.example.assignment.entity.User;
import jakarta.persistence.Query;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public boolean checkUser(String username, String password) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jqpl = "SELECT u FROM User u WHERE u.id = :kwusername AND u.password = :kwpassword";
            Query q = em.createQuery(jqpl);
            q.setParameter("kwusername", username.trim());
            q.setParameter("kwpassword", password.trim());


            List<User> resultList = q.getResultList();
            System.out.println(resultList.get(0).inThongTin());
            return !resultList.isEmpty(); // nếu kết quả không trống : true
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public List<User> getList() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "SELECT u FROM User u";
            Query q = em.createQuery(jpql);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void add(User u) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void removeID(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            User v = em.find(User.class, id);
            em.getTransaction().begin();
            em.remove(v);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public User findID(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(User u) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
