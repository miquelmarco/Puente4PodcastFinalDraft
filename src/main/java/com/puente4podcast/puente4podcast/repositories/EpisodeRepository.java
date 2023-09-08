package com.puente4podcast.puente4podcast.repositories;

import com.puente4podcast.puente4podcast.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
