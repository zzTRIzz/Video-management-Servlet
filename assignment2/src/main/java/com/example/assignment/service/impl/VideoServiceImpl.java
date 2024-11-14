package com.example.assignment.service.impl;

import com.example.assignment.HibernateUtil;
import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    @Override
    public Video findById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(Video.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public Video add(Video m) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return m;
    }

    @Override
    public Video update(Video m) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(m);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return m;
    }

    @Override
    public void deleteById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            Video v = em.find(Video.class, id);
            em.getTransaction().begin();
            em.remove(v);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> findAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "SELECT v FROM Video v";
            Query q = em.createQuery(jpql);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> search(String keyword) {
        //TODO: Implement search logic
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            String jpql = "SELECT v FROM Video v WHERE v.title LIKE :kw";
            Query q = em.createQuery(jpql);
            q.setParameter("kw", "%" + keyword + "%");
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    @Override
    public List<Video> searchFavorite(String userId, String keyword) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "SELECT v FROM Video v WHERE v.id IN (SELECT f.videoid FROM Favorite f WHERE f.userid = :userId) AND v.title LIKE :keyword";
            Query q = em.createQuery(jpql);
            q.setParameter("userId", userId);
            q.setParameter("keyword", "%" + keyword + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean isVideoLikedByUser(String videoId, String userId) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "SELECT COUNT(f) FROM Favorite f WHERE f.videoid = :videoId AND f.userid = :userId";
            Query q = em.createQuery(jpql);
            q.setParameter("videoId", videoId);
            q.setParameter("userId", userId);
            long count = (long) q.getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }



}
