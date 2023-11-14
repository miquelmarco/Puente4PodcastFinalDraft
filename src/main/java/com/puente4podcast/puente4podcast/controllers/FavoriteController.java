package com.puente4podcast.puente4podcast.controllers;

import com.puente4podcast.puente4podcast.models.Episode;
import com.puente4podcast.puente4podcast.models.Favorite;
import com.puente4podcast.puente4podcast.models.PodcastUser;
import com.puente4podcast.puente4podcast.repositories.EpisodeRepository;
import com.puente4podcast.puente4podcast.repositories.FavoriteRepository;
import com.puente4podcast.puente4podcast.repositories.PodcastUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class FavoriteController {

    @Autowired
    private PodcastUserRepository podcastUserRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @PostMapping("/favorite/addFav")
    public ResponseEntity<?> addFav(Authentication authentication, @RequestParam Long id) {
        PodcastUser podcastUser = podcastUserRepository.findByMail(authentication.getName());
        Episode episode = episodeRepository.findById(id).orElse(null);
        if (podcastUser != null && episode != null) {
            Favorite favorite = new Favorite(podcastUser, episode);
            podcastUser.addFavorite(favorite);
            episode.addFavorite(favorite);
            favoriteRepository.save(favorite);
            podcastUserRepository.save(podcastUser);
            episodeRepository.save(episode);
            return new ResponseEntity<>("Agregado a Favoritos", HttpStatus.OK);
        }
        return new ResponseEntity<>("No se ha podido agregar", HttpStatus.FORBIDDEN);
    }
}

