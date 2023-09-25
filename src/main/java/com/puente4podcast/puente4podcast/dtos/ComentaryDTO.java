package com.puente4podcast.puente4podcast.dtos;
import com.puente4podcast.puente4podcast.models.Comentary;
import com.puente4podcast.puente4podcast.models.Episode;
import com.puente4podcast.puente4podcast.models.PodcastUser;
import java.time.LocalDateTime;
public class ComentaryDTO {
    private Long id;
    private String text;
    private LocalDateTime date;
    private PodcastUser podcastUserCom;
    private Episode episode;

    public ComentaryDTO() {
    }
    public ComentaryDTO(Comentary comentary) {
        this.id = comentary.getId();
        this.text = comentary.getText();
        this.date = comentary.getDate();
    }
    public Long getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public PodcastUser getPodcastUserCom() {
        return podcastUserCom;
    }
    public Episode getEpisode() {
        return episode;
    }
}