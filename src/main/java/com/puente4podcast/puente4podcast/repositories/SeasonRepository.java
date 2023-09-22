package com.puente4podcast.puente4podcast.repositories;

import com.puente4podcast.puente4podcast.models.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}