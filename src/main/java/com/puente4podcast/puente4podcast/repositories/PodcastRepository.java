package com.puente4podcast.puente4podcast.repositories;

import com.puente4podcast.puente4podcast.models.Podcast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastRepository extends JpaRepository<Podcast, Long> {
}