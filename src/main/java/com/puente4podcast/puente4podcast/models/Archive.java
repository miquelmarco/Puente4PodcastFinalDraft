package com.puente4podcast.puente4podcast.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private Byte seasonNumber;
    private Byte archiveNumber;
    private String name;
    private String img;
    private String linkYt;
    private String linkIvoox;
    private String duration;
    private String category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "archive_id")
    private Podcast podcastArchive;

    public Archive() {
    }

    public Archive(Byte seasonNumber, Byte archiveNumber, String name, String img, String linkYt, String linkIvoox, String duration, String category, Podcast podcastArchive) {
        this.seasonNumber = seasonNumber;
        this.archiveNumber = archiveNumber;
        this.name = name;
        this.img = img;
        this.linkYt = linkYt;
        this.linkIvoox = linkIvoox;
        this.duration = duration;
        this.category = category;
        this.podcastArchive = podcastArchive;
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

    public Byte getArchiveNumber() {
        return archiveNumber;
    }

    public void setArchiveNumber(Byte episode) {
        this.archiveNumber = episode;
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
    public Podcast getPodcast() {
        return podcastArchive;
    }

    public void setPodcast(Podcast podcast) {
        this.podcastArchive = podcast;
    }
}