package com.puente4podcast.puente4podcast.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private Long number;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "podcast_id")
    private Podcast podcastSeason;
    @OneToMany(mappedBy = "season", fetch = FetchType.EAGER)
    private Set<Episode> episode = new HashSet<>();

    public Season() {
    }

    public Season(Long number, Podcast podcastSeason, Set<Episode> episode) {
        this.number = number;
        this.podcastSeason = podcastSeason;
        this.episode = episode;
    }

    public Long getId() {
        return id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Set<Episode> getEpisode() {
        return episode;
    }

    public void setEpisode(Set<Episode> episode) {
        this.episode = episode;
    }
    @JsonIgnore
    public Podcast getPodcast() {
        return podcastSeason;
    }

    public void setPodcast(Podcast podcast) {
        this.podcastSeason = podcast;
    }
}