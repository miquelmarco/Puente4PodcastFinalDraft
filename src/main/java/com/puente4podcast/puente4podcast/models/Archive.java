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
    private Byte archiveNumber;
    private String name;
    private String img;
    private String linkYt;
    private String linkIvoox;
    private String duration;
    private String category;
    @Column(length = 1000)
    private String description;
    private boolean featured;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "podcast_id")
    private Podcast podcastArchives;

    public Archive() {
    }

    public Archive(Byte archiveNumber, String name, String img, String linkYt, String linkIvoox, String duration, String category, String description, boolean featured) {
        this.archiveNumber = archiveNumber;
        this.name = name;
        this.img = img;
        this.linkYt = linkYt;
        this.linkIvoox = linkIvoox;
        this.duration = duration;
        this.category = category;
        this.description = description;
        this.featured = featured;
    }

    public Long getId() {
        return id;
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

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    @JsonIgnore
    public Podcast getPodcastArchives() {
        return podcastArchives;
    }

    public void setPodcastArchives(Podcast podcastArchives) {
        this.podcastArchives = podcastArchives;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public Podcast getPodcast() {
        return podcastArchives;
    }

    public void setPodcast(Podcast podcast) {
        this.podcastArchives = podcast;
    }
}