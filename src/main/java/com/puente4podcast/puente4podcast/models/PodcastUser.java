package com.puente4podcast.puente4podcast.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class PodcastUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String mail;
    private String nacionality;
    private String password;
    private boolean isAdmin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "podcastOw_id")
    private Podcast podcastUser;
    @OneToMany(mappedBy = "podcastUserCom", fetch = FetchType.EAGER)
    private Set<Comentary> comentarySet = new HashSet<>();
    @OneToMany(mappedBy = "podcastUserFav")
    private Set<Favorite> favoriteSet = new HashSet<>();

    public PodcastUser() {
    }

    public PodcastUser(String firstName, String lastName, String userName, String mail, String nacionality, String password, boolean isAdmin, Podcast podcastUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.mail = mail;
        this.nacionality = nacionality;
        this.password = password;
        this.isAdmin = isAdmin;
        this.podcastUser = podcastUser;
    }

    public PodcastUser(String firstName, String lastName, String userName, String mail, String nacionality, String password, Set<Comentary> comentarySet, Set<Favorite> favoriteSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.mail = mail;
        this.nacionality = nacionality;
        this.password = password;
        this.comentarySet = comentarySet;
        this.favoriteSet = favoriteSet;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Podcast getPodcastUser() {
        return podcastUser;
    }

    public void setPodcastUser(Podcast podcastUser) {
        this.podcastUser = podcastUser;
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

    @JsonIgnore
    public Podcast getPodcastOw() {
        return podcastUser;
    }

    public void setPodcastOw(Podcast podcastOw) {
        this.podcastUser = podcastOw;
    }

    public void addComentary(Comentary comentary) {
        comentary.setPodcastUser(this);
        comentarySet.add(comentary);
    }

    public void addAllComentary(List<Comentary> comentaryList) {
        for (Comentary comentary : comentaryList) {
            this.addComentary(comentary);
        }
    }

    public void addFavorite(Favorite favorite) {
        favorite.setUserFav(this);
        favoriteSet.add(favorite);
    }

    public void addAllFavorite(List<Favorite> favoriteList) {
        for (Favorite favorite : favoriteList) {
            this.addFavorite(favorite);
        }
    }
    public void removeFavorite(Favorite favorite) {
        favoriteSet.remove(favorite);
        favorite.setUserFav(null);
    }
}