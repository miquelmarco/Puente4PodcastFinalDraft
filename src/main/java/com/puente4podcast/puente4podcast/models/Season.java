package com.puente4podcast.puente4podcast.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
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
    private Podcast podcastsSeason;
    @OneToMany(mappedBy = "epSeason", fetch = FetchType.EAGER)
    private Set<Episode> episodes = new HashSet<>();
    public Season() {
    }
    public Season(Long number) {
        this.number = number;
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
    @JsonIgnore
    public Set<Episode> getEpisode() {
        return episodes;
    }
    public void setEpisode(Set<Episode> episode) {
        this.episodes = episode;
    }
    @JsonIgnore
    public Podcast getPodcast() {
        return podcastsSeason;
    }
    public void setPodcast(Podcast podcast) {
        this.podcastsSeason = podcast;
    }
    public void addEpisode (Episode episode) {
        episode.setSeason(this);
        episodes.add(episode);
    }
    public void addAllEpisodes(List<Episode> episodeList) {
        for (Episode episode : episodeList) {
            this.addEpisode(episode);
        }
    }
}