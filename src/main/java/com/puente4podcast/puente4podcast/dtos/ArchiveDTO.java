package com.puente4podcast.puente4podcast.dtos;

import com.puente4podcast.puente4podcast.models.Archive;

public class ArchiveDTO {
    private Long id;
    private Byte archiveNumber;
    private String name;
    private String img;
    private String linkYt;
    private String linkIvoox;
    private String duration;
    private String category;
    private boolean featured;

    public ArchiveDTO() {
    }

    public ArchiveDTO(Archive archive) {
        this.id = archive.getId();
        this.archiveNumber = archive.getArchiveNumber();
        this.name = archive.getName();
        this.img = archive.getImg();
        this.linkYt = archive.getLinkYt();
        this.linkIvoox = archive.getLinkIvoox();
        this.duration = archive.getDuration();
        this.category = archive.getCategory();
        this.featured = archive.isFeatured();
    }

    public Long getId() {
        return id;
    }

    public Byte getArchiveNumber() {
        return archiveNumber;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getLinkYt() {
        return linkYt;
    }

    public String getLinkIvoox() {
        return linkIvoox;
    }

    public String getDuration() {
        return duration;
    }

    public String getCategory() {
        return category;
    }

    public boolean isFeatured() {
        return featured;
    }
}