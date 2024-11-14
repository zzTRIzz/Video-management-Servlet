package com.example.assignment.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userid;
    private String videoid;
    private Date likedate;


//    @ManyToOne @JoinColumn(name = "")id

    // Getters và setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userid;
    }

    public void setUserId(String userId) {
        this.userid = userId;
    }

    public String getVideoId() {
        return videoid;
    }

    public void setVideoId(String videoId) {
        this.videoid = videoId;
    }

    public Date getLikedate() {
        return likedate;
    }

    public void setLikedate(Date likedate) {
        this.likedate = likedate;
    }
}
