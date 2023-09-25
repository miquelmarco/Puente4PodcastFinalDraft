package com.puente4podcast.puente4podcast.dtos;
import com.puente4podcast.puente4podcast.models.Podcast;
import com.puente4podcast.puente4podcast.models.PodcastUser;
import java.util.List;
import java.util.stream.Collectors;
public class PodcastUserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String mail;
    private String nacionality;
    private String password;
    private Podcast podcastUser;
    private List<ComentaryDTO> comentarySet;
    private List<FavoriteDTO> favoriteSet;
    public PodcastUserDTO() {
    }
    public PodcastUserDTO(PodcastUser podcastUser) {
        this.id = podcastUser.getId();
        this.firstName = podcastUser.getFirstName();
        this.lastName = podcastUser.getLastName();
        this.userName = podcastUser.getUserName();
        this.mail = podcastUser.getMail();
        this.nacionality = podcastUser.getNacionality();
        this.password = podcastUser.getPassword();
        this.podcastUser = podcastUser.getPodcastOw();
        this.comentarySet = podcastUser.getComentarySet().stream().map(comentary -> new ComentaryDTO(comentary)).collect(Collectors.toList());
        this.favoriteSet = podcastUser.getFavoriteSet().stream().map(favorite -> new FavoriteDTO(favorite)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUserName() {
        return userName;
    }
    public String getMail() {
        return mail;
    }
    public String getNacionality() {
        return nacionality;
    }
    public String getPassword() {
        return password;
    }
    public Podcast getPodcastUser() {
        return podcastUser;
    }
    public List<ComentaryDTO> getComentarySet() {
        return comentarySet;
    }
    public List<FavoriteDTO> getFavoriteSet() {
        return favoriteSet;
    }
}