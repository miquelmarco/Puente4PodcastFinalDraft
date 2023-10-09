package com.puente4podcast.puente4podcast.controllers;

import com.puente4podcast.puente4podcast.dtos.EpisodeDTO;
import com.puente4podcast.puente4podcast.dtos.NewEpisodeDTO;
import com.puente4podcast.puente4podcast.models.Episode;
import com.puente4podcast.puente4podcast.models.Podcast;
import com.puente4podcast.puente4podcast.models.PodcastUser;
import com.puente4podcast.puente4podcast.models.Season;
import com.puente4podcast.puente4podcast.repositories.EpisodeRepository;
import com.puente4podcast.puente4podcast.repositories.PodcastRepository;
import com.puente4podcast.puente4podcast.repositories.PodcastUserRepository;
import com.puente4podcast.puente4podcast.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EpisodeController {
    @Autowired
    private PodcastRepository podcastRepository;
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private PodcastUserRepository podcastUserRepository;
    @Autowired
    private SeasonRepository seasonRepository;

    @GetMapping("/episodes")
    public List<EpisodeDTO> getAllEps() {
        return episodeRepository.findAll().stream().map(EpisodeDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/episodes/featured")
    public List<EpisodeDTO> getFeatured() {
        return episodeRepository.findAll().stream().filter(Episode::isFeatured).map(EpisodeDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/episodes/newEpisode")
    public ResponseEntity<?> newEpisode(@RequestParam Byte epSeason, @RequestParam Byte epEpisode,
                                        @RequestParam String epName, @RequestParam String epImg,
                                        @RequestParam String epLinkYt, @RequestParam String epLinkIVoox,
                                        @RequestParam String epDuration, @RequestParam String epDescription,
                                        @RequestParam boolean epFeatured, Authentication authentication) {
        PodcastUser podcastUser = podcastUserRepository.findByMail(authentication.getName());
        if (epSeason == null
                || epEpisode == null
                || epName.isBlank()) {
            return new ResponseEntity<>("Datos Erróneos", HttpStatus.FORBIDDEN);
        }
        if (podcastUser.isAdmin()) {
            Episode newEpisode = new Episode(epSeason, epEpisode, epName,
                    epImg, epLinkYt, epLinkIVoox, epDuration,
                    "Canon", epDescription, epFeatured);
            Season getSeason = seasonRepository.findByNumber(epSeason);
            if (getSeason != null) {
                getSeason.addEpisode(newEpisode);
                episodeRepository.save(newEpisode);
            } else {
                Season season = new Season(epSeason);
                Podcast podcast = podcastRepository.findByName("puente4podcast");
                seasonRepository.save(season);
                podcast.addSeason(season);
                season.addEpisode(newEpisode);
                episodeRepository.save(newEpisode);
            }
            return new ResponseEntity<>("Episodio Ingresado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sólo un admin puede ingresar un episodio!", HttpStatus.FORBIDDEN);
        }
    }
}