package com.puente4podcast.puente4podcast.controllers;

import com.puente4podcast.puente4podcast.dtos.ArchiveDTO;
import com.puente4podcast.puente4podcast.models.Archive;
import com.puente4podcast.puente4podcast.repositories.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController @RequestMapping("/api")
public class ArchiveController {
    @Autowired
    private ArchiveRepository archiveRepository;
    @GetMapping("/archives/featured")
    public List<ArchiveDTO> getFeatured() {
        return archiveRepository.findAll().stream().filter(Archive::isFeatured).map(ArchiveDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/archives/getArchives")
    public List<ArchiveDTO> getArchives() {
        return archiveRepository.findAll().stream().map(ArchiveDTO::new).collect(Collectors.toList());
    }
}