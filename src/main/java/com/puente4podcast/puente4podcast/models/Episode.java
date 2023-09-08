package com.puente4podcast.puente4podcast.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private Byte seasonNumber;
    private Byte episode;
    private String name;
    private String img;
    private String linkYt;
    private String linkIvoox;
    private String duration;
    private String category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "season_id")
    private Season season;
    @OneToMany(mappedBy = "episode", fetch = FetchType.EAGER)
    private Set<Comentary> comentarySet = new HashSet<>();
    @OneToMany(mappedBy = "episodeFav", fetch = FetchType.EAGER)
    private Set<Favorite> favoriteSet = new HashSet<>();

    public Episode() {
    }

    public Episode(Byte seasonNumber, Byte episode, String name, String img, String linkYt, String linkIvoox, String duration, String category) {
        this.seasonNumber = seasonNumber;
        this.episode = episode;
        this.name = name;
        this.img = img;
        this.linkYt = linkYt;
        this.linkIvoox = linkIvoox;
        this.duration = duration;
        this.category = category;
//        this.season = season;
//        this.comentarySet = comentarySet;
//        this.favoriteSet = favoriteSet;
    }

    public Long getId() {
        return id;
    }

    public Byte getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Byte seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Byte getEpisode() {
        return episode;
    }

    public void setEpisode(Byte episode) {
        this.episode = episode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLinkYt() {
        return linkYt;
    }

    public void setLinkYt(String linkYt) {
        this.linkYt = linkYt;
    }

    public String getLinkIvoox() {
        return linkIvoox;
    }

    public void setLinkIvoox(String linkIvoox) {
        this.linkIvoox = linkIvoox;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @JsonIgnore
    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    @JsonIgnore
    public Set<Comentary> getComentarySet() {
        return comentarySet;
    }

    public void setComentarySet(Set<Comentary> comentarySet) {
        this.comentarySet = comentarySet;
    }

    @JsonIgnore
    public Set<Favorite> getFavoriteSet() {
        return favoriteSet;
    }

    public void setFavoriteSet(Set<Favorite> favoriteSet) {
        this.favoriteSet = favoriteSet;
    }
}