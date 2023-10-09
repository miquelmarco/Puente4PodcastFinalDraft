package com.puente4podcast.puente4podcast.controllers;

import com.puente4podcast.puente4podcast.models.Podcast;
import com.puente4podcast.puente4podcast.models.PodcastUser;
import com.puente4podcast.puente4podcast.repositories.PodcastRepository;
import com.puente4podcast.puente4podcast.repositories.PodcastUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PodcastUserController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PodcastUserRepository podcastUserRepository;
    @Autowired
    PodcastRepository podcastRepository;

    @PostMapping("/register")
    public ResponseEntity<Object> registerPodcastUser(@RequestParam String firstName, @RequestParam String lastName,
                                                      @RequestParam String userName, @RequestParam String mail,
                                                      @RequestParam String nacionality, @RequestParam String password) {
        if (password.isBlank()) {
            return new ResponseEntity<>("Ingresa tu contraseña", HttpStatus.FORBIDDEN);
        }
        if (firstName.isBlank()) {
            return new ResponseEntity<>("Ingresa tu nombre", HttpStatus.FORBIDDEN);
        }
        if (lastName.isBlank()) {
            return new ResponseEntity<>("Ingresa tu apellido", HttpStatus.FORBIDDEN);
        }
        if (userName.isBlank()) {
            return new ResponseEntity<>("Ingresa tu nombre de usuario", HttpStatus.FORBIDDEN);
        }
        if (mail.isBlank()) {
            return new ResponseEntity<>("Ingresa tu mail", HttpStatus.FORBIDDEN);
        }
        if (nacionality.isBlank()) {
            return new ResponseEntity<>("Indica tu nacionalidad", HttpStatus.FORBIDDEN);
        }
        if (podcastUserRepository.findByMail(mail) != null) {
            return new ResponseEntity<>("Usuario ya existe", HttpStatus.FORBIDDEN);
        }
        if (podcastUserRepository.findByUserName(userName) != null) {
            return new ResponseEntity<>("Nombre de usuario en uso", HttpStatus.FORBIDDEN);
        }
        Podcast podcast = podcastRepository.findByName("puente4podcast");
        PodcastUser podcastUser = new PodcastUser(firstName, lastName, userName, mail, nacionality, passwordEncoder.encode(password), false, podcast);

        podcastUserRepository.save(podcastUser);
        return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<Object> registerAdmin(@RequestParam String firstName, @RequestParam String lastName,
                                                      @RequestParam String userName, @RequestParam String mail,
                                                      @RequestParam String nacionality, @RequestParam String password) {
        if (password.isBlank()) {
            return new ResponseEntity<>("Ingresa Contraseña", HttpStatus.FORBIDDEN);
        }
        if (firstName.isBlank()) {
            return new ResponseEntity<>("Ingresa Nombre", HttpStatus.FORBIDDEN);
        }
        if (lastName.isBlank()) {
            return new ResponseEntity<>("Ingresa Apellido", HttpStatus.FORBIDDEN);
        }
        if (userName.isBlank()) {
            return new ResponseEntity<>("Ingresa Nombre de Usuario", HttpStatus.FORBIDDEN);
        }
        if (mail.isBlank()) {
            return new ResponseEntity<>("Ingresa Mail", HttpStatus.FORBIDDEN);
        }
        if (nacionality.isBlank()) {
            return new ResponseEntity<>("Indica Nacionalidad", HttpStatus.FORBIDDEN);
        }
        if (podcastUserRepository.findByMail(mail) != null) {
            return new ResponseEntity<>("Usuario ya existe", HttpStatus.FORBIDDEN);
        }
        if (podcastUserRepository.findByUserName(userName) != null) {
            return new ResponseEntity<>("Nombre de usuario en uso", HttpStatus.FORBIDDEN);
        }
        Podcast podcast = podcastRepository.findByName("puente4podcast");
        PodcastUser podcastUser = new PodcastUser(firstName, lastName, userName, mail, nacionality, passwordEncoder.encode(password), true, podcast);

        podcastUserRepository.save(podcastUser);
        return new ResponseEntity<>("Administrador Creado", HttpStatus.CREATED);
    }
}