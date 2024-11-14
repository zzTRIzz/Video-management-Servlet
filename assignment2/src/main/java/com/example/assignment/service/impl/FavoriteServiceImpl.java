package com.example.assignment.service.impl;

import com.example.assignment.HibernateUtil;
import com.example.assignment.entity.Favorite;
import com.example.assignment.service.FavoriteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Date;
import java.util.UUID;

public class FavoriteServiceImpl implements FavoriteService {

    @Override
    public void add(Favorite favorite) {
        // Thiết lập likedate
        favorite.setLikedate(new Date());

        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(favorite);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void remove(String userId, String videoId) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            Favorite favorite = em.createQuery(
                "SELECT f FROM Favorite f WHERE f.userid = :userId AND f.videoid = :videoId", Favorite.class)
                .setParameter("userId", userId)
                .setParameter("videoId", videoId)
                .getSingleResult();
            if (favorite != null) {
                em.remove(favorite);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


}
