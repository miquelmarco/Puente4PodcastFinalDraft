package com.puente4podcast.puente4podcast.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userFav;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "episode_id")
    private Episode episodeFav;

    public Favorite() {
    }

    public Favorite(User userFav, Episode episodeFav) {
        this.userFav = userFav;
        this.episodeFav = episodeFav;
    }

    public Long getId() {
        return id;
    }

    public User getUserFav() {
        return userFav;
    }

    public void setUserFav(User userFav) {
        this.userFav = userFav;
    }

    public Episode getEpisodeFav() {
        return episodeFav;
    }

    public void setEpisodeFav(Episode episodeFav) {
        this.episodeFav = episodeFav;
    }
}