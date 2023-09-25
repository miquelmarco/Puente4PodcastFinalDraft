package com.puente4podcast.puente4podcast.controllers;
import com.puente4podcast.puente4podcast.dtos.EpisodeDTO;
import com.puente4podcast.puente4podcast.models.Episode;
import com.puente4podcast.puente4podcast.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
@RestController @RequestMapping("/api")
public class EpisodeController {
    @Autowired    private EpisodeRepository episodeRepository;
    @GetMapping("/episodes")
    public List<EpisodeDTO> getAllEps() {
        return episodeRepository.findAll().stream().map(EpisodeDTO::new).collect(Collectors.toList());
    }
    @GetMapping("/episodes/featured")
    public List<EpisodeDTO> getFeatured() {
        return episodeRepository.findAll().stream().filter(Episode::isFeatured).map(EpisodeDTO::new).collect(Collectors.toList());
    }
}