package com.puente4podcast.puente4podcast.controllers;

import com.puente4podcast.puente4podcast.dtos.EpisodeDTO;
import com.puente4podcast.puente4podcast.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api")
public class ComentaryController {
    @Autowired
    private EpisodeRepository episodeRepository;

    @GetMapping("/episodes/{id}")
    public EpisodeDTO getComentByEp(@PathVariable Long id) {
     return episodeRepository.findById(id).map(EpisodeDTO::new).orElse(null);
    }
}