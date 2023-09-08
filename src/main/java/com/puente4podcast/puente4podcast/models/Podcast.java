package com.puente4podcast.puente4podcast.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Podcast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String name;
    private String description;
    private String banner;
    @OneToMany(mappedBy = "podcast", fetch = FetchType.EAGER)
    private Set<Season> season = new HashSet<>();
    @OneToMany(mappedBy = "archive", fetch = FetchType.EAGER)
    private Set<Archive> archive = new HashSet<>();

    public Podcast() {
    }

    public Podcast(String name, String description, String banner, Set<Season> season, Set<Archive> archive) {
        this.name = name;
        this.description = description;
        this.banner = banner;
        this.season = season;
        this.archive = archive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Set<Season> getSeason() {
        return season;
    }

    public void setSeason(Set<Season> season) {
        this.season = season;
    }

    public Set<Archive> getArchive() {
        return archive;
    }

    public void setArchive(Set<Archive> archive) {
        this.archive = archive;
    }
}