package com.puente4podcast.puente4podcast.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Comentary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String text;
    private String date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "episode_id")
    private Episode episode;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private PodcastUser podcastUser;

    public Comentary() {
    }

    public Comentary(String text, String date, Episode episode, PodcastUser podcastUser) {
        this.text = text;
        this.date = date;
//        this.episode = episode;
//        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public PodcastUser getUser() {
        return podcastUser;
    }

    public void setUser(PodcastUser podcastUser) {
        this.podcastUser = podcastUser;
    }
}